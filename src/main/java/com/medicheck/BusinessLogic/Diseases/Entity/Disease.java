package com.medicheck.BusinessLogic.Diseases.Entity;

import com.medicheck.BusinessLogic.DiseaseSymptom.Entity.DiseaseSymptom;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;


import java.util.List;
import java.util.UUID;


@Builder
@Data
@Entity
public class Disease {
    @Id
    @GeneratedValue
    private UUID id;

    private String name; // Name of the disease
    private String description; // Description of the disease
    private List<DiseaseSymptom> symptoms; // Common symptoms associated with the disease




}