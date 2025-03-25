package com.medicheck.BusinessLogic.Symptoms.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Symptom implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    private String name; // Name of the Symptom
    private String description; // Description of the symptom



}