package com.medicheck.BusinessLogic.DiseaseSymptom.repository;

import com.medicheck.BusinessLogic.DiseaseSymptom.Entity.DiseaseSymptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiseaseSymptomRepository extends JpaRepository<DiseaseSymptom, UUID> {
}
