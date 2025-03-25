package com.medicheck.BusinessLogic.DoctorApplications.repository;

import com.medicheck.BusinessLogic.DoctorApplications.entity.DoctorApplication;
import com.medicheck.BusinessLogic.Users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface DoctorApplicationRepository extends JpaRepository<DoctorApplication, UUID> {
    List<DoctorApplication> findByUserOrderByDoneOnDesc(User currentUser);

    @Query("select a from DoctorApplication a where a.applicationStatus = ApplicationStatus.PENDING and a.user.approved=false order by a.doneOn Asc")
    List<DoctorApplication> listDoctorApplications(User currentUser);
}
