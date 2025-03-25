package com.medicheck.BusinessLogic.Diagnosis.repository;

import com.medicheck.BusinessLogic.Diagnosis.entity.DiagnosisStatus;
import com.medicheck.BusinessLogic.Diagnosis.entity.DiagnosisType;
import com.medicheck.BusinessLogic.Diagnosis.entity.MedicalDiagnosis;
import com.medicheck.BusinessLogic.Users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicalDiagnosisRepository extends JpaRepository<MedicalDiagnosis, UUID> {
    List<MedicalDiagnosis> findByUserOrderByCreatedOnDesc(User user);

//    List<MedicalDiagnosis> findByDiagnosisStatusPendingAndDiagnosisTypeDoctorOrderByCreatedOnAsc();
//
//    List<MedicalDiagnosis> findByDiagnosisStatusDIAGONALIZEDAndDiagnosisTypeDoctorAndDiagonalizedByOrderByCreatedOnDesc(User user);

    List<MedicalDiagnosis> findByDiagnosisStatusAndDiagnosisTypeOrderByCreatedOnAsc(DiagnosisStatus status, DiagnosisType type);

    List<MedicalDiagnosis> findByDiagnosisStatusAndDiagnosisTypeAndDiagonalizedByOrderByCreatedOnDesc(
            DiagnosisStatus status, DiagnosisType type, User diagnosedBy
    );
}
