package com.medicheck.BusinessLogic.DoctorApplications.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicheck.BusinessLogic.Users.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class DoctorApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uid;

    @ManyToOne
    private User user;

    @Column(columnDefinition = "TEXT")
    private String coverLetter;

    private Date doneOn;

    private ApplicationStatus applicationStatus;


    @JsonIgnore
    @ManyToOne
    private User actionBy;

    private Date actionDate;


}
