package com.medicheck.BusinessLogic.Diseases.Service;


import com.medicheck.BusinessLogic.Diseases.Entity.Disease;
import com.medicheck.BusinessLogic.Diseases.Repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }

    public Disease getDiseaseById(UUID id) {
        return diseaseRepository.findById(id).orElse(null);
    }

    public void saveDisease(Disease disease) {
        diseaseRepository.save(disease);
    }

    public Disease extractDisease(String disease) {

        Optional<Disease> optionalDisease = diseaseRepository.findByNameIgnoreCase(disease);
        if(optionalDisease.isPresent())
            return optionalDisease.get();
        else
        {
            Disease disease1 = Disease.builder()
                    .name(disease)
                    .description(disease)
                    .symptoms(Collections.emptyList())
                    .build();
            diseaseRepository.saveAndFlush(disease1);
            return disease1;
        }

    }
}