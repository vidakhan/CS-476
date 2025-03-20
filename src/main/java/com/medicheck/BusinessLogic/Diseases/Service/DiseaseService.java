package com.medicheck.BusinessLogic.Diseases.Service;


import com.medicheck.BusinessLogic.Diseases.Entity.Disease;
import com.medicheck.BusinessLogic.Diseases.Repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}