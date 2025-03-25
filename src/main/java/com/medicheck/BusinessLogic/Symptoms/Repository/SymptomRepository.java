package com.medicheck.BusinessLogic.Symptoms.Repository;


import com.medicheck.BusinessLogic.Symptoms.Entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, UUID> {
    Optional<Symptom> findByNameIgnoreCase(String symptom);

}