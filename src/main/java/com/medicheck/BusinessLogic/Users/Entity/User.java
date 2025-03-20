package com.medicheck.BusinessLogic.Users.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.util.UUID;

@Data
@Builder
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String userType; // General User or Admin/Medical Professional

}