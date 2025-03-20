package com.medicheck.BusinessLogic.Symptoms.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity

public class Symptom {
    @Id
    @GeneratedValue
    private UUID id;

    private String name; // Name of the Symptom
    private String description; // Description of the symptom



}