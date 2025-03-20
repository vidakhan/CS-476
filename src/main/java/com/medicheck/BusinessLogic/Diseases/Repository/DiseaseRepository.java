package com.medicheck.BusinessLogic.Diseases.Repository;


import com.medicheck.BusinessLogic.Diseases.Entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiseaseRepository extends JpaRepository<Disease, UUID> {
}