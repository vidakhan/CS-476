package com.medicheck.BusinessLogic.Symptoms.Service;


import com.medicheck.BusinessLogic.Symptoms.Entity.Symptom;
import com.medicheck.BusinessLogic.Symptoms.Repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    public List<Symptom> getAllSymptoms() {
        return symptomRepository.findAll();
    }

    public Symptom getSymptomById(UUID id) {
        return symptomRepository.findById(id).orElse(null);
    }

    public void saveSymptom(Symptom symptom) {
        symptomRepository.save(symptom);
    }
}