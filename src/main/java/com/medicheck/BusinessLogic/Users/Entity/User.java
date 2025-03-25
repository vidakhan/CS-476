package com.medicheck.BusinessLogic.Users.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Builder
@Entity(name = "users_table")
public class User {
    @Id
    @GeneratedValue
    private UUID uid;

    @Column(unique = true)
    private String username;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @JsonIgnore
    @ManyToOne
    private User addedBy;

    @Column(columnDefinition = "boolean default false")
    private boolean approved;

    private Long addedOn;

    private Long createdOn;

    @Column(columnDefinition = "boolean default false")
    private Boolean attemptedDoctor;

}