package com.medicheck.BusinessLogic.DoctorApplications.controller;


import com.medicheck.BusinessLogic.DoctorApplications.entity.DoctorApplication;
import com.medicheck.BusinessLogic.DoctorApplications.service.DoctorsApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/applications")
public class DoctorApplicationsController {

    @Autowired
    private DoctorsApplicationService doctorsApplicationService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/listDoctorApplications")
    public ResponseEntity<List<DoctorApplication>> listDoctorsApplications()
    {
        return doctorsApplicationService.listDoctorsApplications();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/approveApplication/{application_id}")
    public ResponseEntity<String> approveApplication(@PathVariable("application_id")UUID applicationId)
    {
        return doctorsApplicationService.approveApplication(applicationId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/reject/{application_id}")
    public ResponseEntity<String> RejectApplication(@PathVariable("application_id")UUID applicationId)
    {
        return doctorsApplicationService.rejectApplication(applicationId);
    }




}
