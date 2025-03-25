package com.medicheck.BusinessLogic.Diagnosis.entity;


import com.medicheck.BusinessLogic.DiseaseSymptom.Entity.DiseaseSymptom;
import com.medicheck.BusinessLogic.Diseases.Entity.Disease;
import com.medicheck.BusinessLogic.Users.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


@Entity
public class MedicalDiagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uid;

    @ManyToOne
    private User user;


    private DiagnosisType diagnosisType;

    @ManyToMany
    private List<DiseaseSymptom> diseaseSymptom;

    @Column(columnDefinition = "TEXT")
    private String description;


    private DiagnosisStatus diagnosisStatus;

    private Date createdOn;


    @ManyToOne
    private Disease disease;

    private double probabilityPercentage;

    @Column(columnDefinition = "TEXT")
    private String diagnosisDescription;

    @Column(columnDefinition = "TEXT")
    private String recommendedMedication;


    private Date resultsOn;


    @ManyToOne
    private User diagonalizedBy;


}
