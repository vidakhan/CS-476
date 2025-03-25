package com.medicheck.BusinessLogic.DoctorApplications.service;

import com.medicheck.BusinessLogic.DoctorApplications.entity.ApplicationStatus;
import com.medicheck.BusinessLogic.DoctorApplications.entity.DoctorApplication;
import com.medicheck.BusinessLogic.DoctorApplications.repository.DoctorApplicationRepository;
import com.medicheck.BusinessLogic.Users.Entity.User;
import com.medicheck.BusinessLogic.Users.Entity.UserRole;
import com.medicheck.BusinessLogic.Users.Repository.UserRepository;
import com.medicheck.BusinessLogic.Users.Service.UserService;
import com.medicheck.BusinessLogic.Users.models.DoctorApplicationRequest;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@SuppressWarnings("unused")
@Service
public class DoctorsApplicationService {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorApplicationRepository doctorApplicationRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> applyAsDoctor(DoctorApplicationRequest doctorApplicationRequest) {

        User currentUser = userService.currentUser();
        if(currentUser==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UnAuthorized");

        if(currentUser.isApproved())
            throw new IllegalArgumentException("Already Approved");

        DoctorApplication doctorApplication = DoctorApplication.builder()
                .applicationStatus(ApplicationStatus.PENDING)
                .user(currentUser)
                .coverLetter(doctorApplicationRequest.getCoverLetter())
                .doneOn(new Date())
                .build();
        doctorApplicationRepository.saveAndFlush(doctorApplication);

        currentUser.setAttemptedDoctor(true);
        userRepository.save(currentUser);

        return ResponseEntity.ok("Applied Successfully, waiting for approval");

    }

    public ResponseEntity<List<DoctorApplication>> myApplications() {
        User currentUser = userService.currentUser();
        if(currentUser==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        return ResponseEntity.ok(doctorApplicationRepository.findByUserOrderByDoneOnDesc(currentUser));
    }

    public ResponseEntity<List<DoctorApplication>> listDoctorsApplications() {
        User currentUser = userService.currentUser();
        if(currentUser==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        return ResponseEntity.ok(doctorApplicationRepository.listDoctorApplications(currentUser));
    }

    public ResponseEntity<String> approveApplication(UUID applicationId) {
        User currentUser = userService.currentUser();
        if(currentUser==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        Optional<DoctorApplication> optionalDoctorApplication = doctorApplicationRepository.findById(applicationId);
        if(optionalDoctorApplication.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Application Not Found");
        DoctorApplication doctorApplication = optionalDoctorApplication.get();

        if(doctorApplication.getUser().isApproved())
            throw new UnsupportedOperationException ("Doctor Already Approved");

        doctorApplication.setApplicationStatus(ApplicationStatus.APPROVED);
        doctorApplication.setActionBy(currentUser);
        doctorApplication.setActionDate(new Date());

        doctorApplication.getUser().setApproved(true);
        doctorApplication.getUser().setRole(UserRole.ROLE_DOCTOR);
        userRepository.saveAndFlush(doctorApplication.getUser());

        doctorApplicationRepository.saveAndFlush(doctorApplication);

        return ResponseEntity.ok("Approved Successfully");
    }

    public ResponseEntity<String> rejectApplication(UUID applicationId) {
        User currentUser = userService.currentUser();
        if(currentUser==null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        Optional<DoctorApplication> optionalDoctorApplication = doctorApplicationRepository.findById(applicationId);
        if(optionalDoctorApplication.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Application Not Found");
        DoctorApplication doctorApplication = optionalDoctorApplication.get();

        if(doctorApplication.getApplicationStatus()!=ApplicationStatus.PENDING)
            throw new UnsupportedOperationException ("Application Already Responded To");

        doctorApplication.setApplicationStatus(ApplicationStatus.REJECTED);
        doctorApplication.setActionBy(currentUser);
        doctorApplication.setActionDate(new Date());

        doctorApplication.getUser().setApproved(false);
        userRepository.saveAndFlush(doctorApplication.getUser());

        doctorApplicationRepository.saveAndFlush(doctorApplication);

        return ResponseEntity.ok("Rejected Successfully");
    }
}
