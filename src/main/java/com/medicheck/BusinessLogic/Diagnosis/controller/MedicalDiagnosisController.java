package com.medicheck.BusinessLogic.Diagnosis.controller;


import com.medicheck.BusinessLogic.Diagnosis.entity.MedicalDiagnosis;
import com.medicheck.BusinessLogic.Diagnosis.model.DiagnosisRequest;
import com.medicheck.BusinessLogic.Diagnosis.model.DoctorDiagnosisRequest;
import com.medicheck.BusinessLogic.Diagnosis.model.DoctorMakeDiagnosisRequest;
import com.medicheck.BusinessLogic.Diagnosis.service.MedicalDiagnosisService;
import com.medicheck.Utils.Predictor.DiseasesPredictor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

@RequestMapping("/api/v1/diagnosis")
public class MedicalDiagnosisController {

    @Autowired
    private MedicalDiagnosisService medicalDiagnosisService;

    @PostMapping("/requestDiagnosis")
    public ResponseEntity<MedicalDiagnosis> requestDiagnosis(@RequestBody DiagnosisRequest diagnosisRequest)
    {
        return medicalDiagnosisService.requestDiagnosis(diagnosisRequest);
    }


    @PostMapping("/requestDoctorDiagnosis")
    public ResponseEntity<MedicalDiagnosis> requestDoctorsDiagnosis(@RequestBody DoctorDiagnosisRequest doctorDiagnosisRequest)
    {
        return medicalDiagnosisService.requestDoctorDiagnosis(doctorDiagnosisRequest);
    }

    @GetMapping("/myDiagnosis")
    public ResponseEntity<List<MedicalDiagnosis>> myDiagnosis()
    {
        return medicalDiagnosisService.myDiagnosis();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_DOCTOR','ROLE_ADMIN')")
    @GetMapping("/pendingDiagnosis")
    public ResponseEntity<List<MedicalDiagnosis>> pendingDiagnosis()
    {
        return medicalDiagnosisService.pendingDiagnosis();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_DOCTOR','ROLE_ADMIN')")
    @GetMapping("/myContributions")
    public ResponseEntity<List<MedicalDiagnosis>> myContributions()
    {
        return medicalDiagnosisService.myContributions();
    }




    @PreAuthorize("hasAnyAuthority('ROLE_DOCTOR','ROLE_ADMIN')")
    @PostMapping("/medicate")
    public ResponseEntity<String> medicate(@Valid @RequestBody DoctorMakeDiagnosisRequest doctorDiagnosisRequest)
    {
        return medicalDiagnosisService.medicate(doctorDiagnosisRequest);
    }


    @GetMapping("/symptomsList")
    public ResponseEntity<List<String>> symptomsList()
    {
        return ResponseEntity.ok(DiseasesPredictor.symptomsList);
    }



    @PreAuthorize("hasAnyAuthority('ROLE_DOCTOR','ROLE_ADMIN')")
    @GetMapping("/view/{id}")
    public ResponseEntity<MedicalDiagnosis> view(@PathVariable("id")UUID id)
    {
        return medicalDiagnosisService.view(id);
    }



}
