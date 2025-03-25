package com.medicheck.BusinessLogic.Diagnosis.service;


import com.medicheck.BusinessLogic.Diagnosis.entity.DiagnosisStatus;
import com.medicheck.BusinessLogic.Diagnosis.entity.DiagnosisType;
import com.medicheck.BusinessLogic.Diagnosis.entity.MedicalDiagnosis;
import com.medicheck.BusinessLogic.Diagnosis.model.DiagnosisRequest;
import com.medicheck.BusinessLogic.Diagnosis.model.DoctorDiagnosisRequest;
import com.medicheck.BusinessLogic.Diagnosis.model.DoctorMakeDiagnosisRequest;
import com.medicheck.BusinessLogic.Diagnosis.model.SymptomItem;
import com.medicheck.BusinessLogic.Diagnosis.repository.MedicalDiagnosisRepository;
import com.medicheck.BusinessLogic.DiseaseSymptom.Entity.DiseaseSymptom;
import com.medicheck.BusinessLogic.DiseaseSymptom.repository.DiseaseSymptomRepository;
import com.medicheck.BusinessLogic.Diseases.Service.DiseaseService;
import com.medicheck.BusinessLogic.Symptoms.Service.SymptomService;
import com.medicheck.BusinessLogic.Users.Service.UserService;
import com.medicheck.Utils.Predictor.DiseasesPredictor;
import com.medicheck.Utils.Predictor.PredictionResultModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicalDiagnosisService {

    @Autowired
    private MedicalDiagnosisRepository medicalDiagnosisRepository;

    @Autowired
    private SymptomService symptomService;


    @Autowired
    private DiseaseService diseaseService;


    @Autowired
    private UserService userService;

    @Autowired
    private DiseaseSymptomRepository diseaseSymptomRepository;

    public ResponseEntity<MedicalDiagnosis> requestDiagnosis(@Valid DiagnosisRequest diagnosisRequest) {

        if(diagnosisRequest.getSymptoms().size()==0)
             throw new IllegalArgumentException("No symptoms found");
        List<DiseaseSymptom> diseaseSymptoms = new LinkedList<>();
        HashSet<String> symptomsSet = new HashSet<>();
        for(SymptomItem i:diagnosisRequest.getSymptoms())
        {
            DiseaseSymptom diseaseSymptom = DiseaseSymptom.builder()
                    .symptom(symptomService.extractSymptom(i.getSymptom().trim()))
                    .severity(i.getSeverity())
                    .build();
            diseaseSymptomRepository.saveAndFlush(diseaseSymptom);
            diseaseSymptoms.add(diseaseSymptom);
            symptomsSet.add(i.getSymptom().trim());

        }

        Date started= new Date();
        PredictionResultModel result = DiseasesPredictor.predict(symptomsSet);
        String medication = DiseasesPredictor.getMedication(result);


        MedicalDiagnosis medicalDiagnosis = MedicalDiagnosis.builder()
                .user(userService.currentUser())
                .diagnosisType(DiagnosisType.AUTO)
                .diseaseSymptom(diseaseSymptoms)
                .diagnosisStatus(DiagnosisStatus.DIAGONALIZED)
                .probabilityPercentage(result.getScore())
                .disease(diseaseService.extractDisease(result.getDisease().trim()))
                .createdOn(started)
                .resultsOn(new Date())
                .recommendedMedication(medication)
                .build();

        medicalDiagnosisRepository.saveAndFlush(medicalDiagnosis);

        return ResponseEntity.ok(medicalDiagnosis);
    }


    public ResponseEntity<MedicalDiagnosis> requestDoctorDiagnosis(@Valid DoctorDiagnosisRequest doctorDiagnosisRequest) {

        if(doctorDiagnosisRequest.getSymptoms().size()==0)
            throw new IllegalArgumentException("No symptoms found");

        if(doctorDiagnosisRequest.getDescription()==null||doctorDiagnosisRequest.getDescription().isEmpty())
            throw new IllegalArgumentException("You must describe how you are feeling");

        List<DiseaseSymptom> diseaseSymptoms = new LinkedList<>();
        HashSet<String> symptomsSet = new HashSet<>();
        for(SymptomItem i:doctorDiagnosisRequest.getSymptoms())
        {
            DiseaseSymptom diseaseSymptom = DiseaseSymptom.builder()
                    .symptom(symptomService.extractSymptom(i.getSymptom().trim()))
                    .severity(i.getSeverity())
                    .build();
            diseaseSymptomRepository.saveAndFlush(diseaseSymptom);
            diseaseSymptoms.add(diseaseSymptom);
            symptomsSet.add(i.getSymptom().trim());

        }

        Date started= new Date();
        MedicalDiagnosis medicalDiagnosis = MedicalDiagnosis.builder()
                .user(userService.currentUser())
                .diagnosisType(DiagnosisType.DOCTOR)
                .diseaseSymptom(diseaseSymptoms)
                .description(doctorDiagnosisRequest.getDescription())
                .diagnosisStatus(DiagnosisStatus.PENDING)
                .probabilityPercentage(0)
                .createdOn(started)
                .build();

        medicalDiagnosisRepository.saveAndFlush(medicalDiagnosis);

        return ResponseEntity.ok(medicalDiagnosis);
    }

    public ResponseEntity<List<MedicalDiagnosis>> myDiagnosis() {
        return ResponseEntity.ok(medicalDiagnosisRepository.findByUserOrderByCreatedOnDesc(userService.currentUser()));
    }


    public ResponseEntity<List<MedicalDiagnosis>> pendingDiagnosis() {
//        return ResponseEntity.ok(medicalDiagnosisRepository.findByDiagnosisStatusPendingAndDiagnosisTypeDoctorOrderByCreatedOnAsc());
        return ResponseEntity.ok(medicalDiagnosisRepository.findByDiagnosisStatusAndDiagnosisTypeOrderByCreatedOnAsc(DiagnosisStatus.PENDING,DiagnosisType.DOCTOR));
    }


    public ResponseEntity<List<MedicalDiagnosis>> myContributions() {
//        return ResponseEntity.ok(medicalDiagnosisRepository.findByDiagnosisStatusDIAGONALIZEDAndDiagnosisTypeDoctorAndDiagonalizedByOrderByCreatedOnDesc(userService.currentUser()));
        return ResponseEntity.ok(medicalDiagnosisRepository.findByDiagnosisStatusAndDiagnosisTypeAndDiagonalizedByOrderByCreatedOnDesc(DiagnosisStatus.DIAGONALIZED,DiagnosisType.DOCTOR,userService.currentUser()));
    }



    public ResponseEntity<String> medicate(@Valid DoctorMakeDiagnosisRequest doctorDiagnosisRequest) {

        Optional<MedicalDiagnosis> optionalMedicalDiagnosis = medicalDiagnosisRepository.findById(doctorDiagnosisRequest.getDiagnosisId());
        if(optionalMedicalDiagnosis.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Diagnosis not found");

        MedicalDiagnosis medicalDiagnosis = optionalMedicalDiagnosis.get();

        if(medicalDiagnosis.getDiagnosisStatus()==DiagnosisStatus.DIAGONALIZED)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already Diagonalized");

        if(medicalDiagnosis.getUser().getUid().equals(userService.currentUser().getUid()))
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Can`t Diagonalize your own disease");

        medicalDiagnosis.setDiagnosisDescription(doctorDiagnosisRequest.getFindings());
        medicalDiagnosis.setRecommendedMedication(doctorDiagnosisRequest.getMedication());

        medicalDiagnosis.setDiagnosisStatus(DiagnosisStatus.DIAGONALIZED);
        medicalDiagnosis.setDiagonalizedBy(userService.currentUser());
        medicalDiagnosis.setResultsOn(new Date());

        medicalDiagnosisRepository.saveAndFlush(medicalDiagnosis);

        return ResponseEntity.ok("Sent Successfully");
    }


    public ResponseEntity<MedicalDiagnosis> view(@Valid UUID id) {
        Optional<MedicalDiagnosis> optionalMedicalDiagnosis = medicalDiagnosisRepository.findById(id);
        if(optionalMedicalDiagnosis.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        else
            return ResponseEntity.ok(optionalMedicalDiagnosis.get());
    }
}
