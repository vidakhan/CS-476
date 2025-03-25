package com.medicheck.BusinessLogic.Diseases.Repository;


import com.medicheck.BusinessLogic.Diseases.Entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, UUID> {
    Optional<Disease> findByNameIgnoreCase(String disease);

}