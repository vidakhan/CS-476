package com.medicheck.BusinessLogic.Users.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserModelRequest
{

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}