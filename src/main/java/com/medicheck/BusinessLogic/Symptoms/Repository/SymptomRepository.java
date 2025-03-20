package com.medicheck.BusinessLogic.Symptoms.Repository;


import com.medicheck.BusinessLogic.Symptoms.Entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SymptomRepository extends JpaRepository<Symptom, UUID> {
}