package com.medicheck.BusinessLogic.DiseaseSymptom.Entity;


import com.medicheck.BusinessLogic.Symptoms.Entity.Symptom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Embeddable
public class DiseaseSymptom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne
    private Symptom symptom;

    private Severity severity;


}
