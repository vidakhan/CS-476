package com.medicheck.BusinessLogic.Diseases.Entity;

import com.medicheck.BusinessLogic.DiseaseSymptom.Entity.DiseaseSymptom;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor

@Builder
@Data
@Entity
public class Disease {
    @Id
    @GeneratedValue
    private UUID id;

    private String name; // Name of the disease
    private String description; // Description of the disease

    @ElementCollection
    private List<DiseaseSymptom> symptoms; // Common symptoms associated with the disease




}