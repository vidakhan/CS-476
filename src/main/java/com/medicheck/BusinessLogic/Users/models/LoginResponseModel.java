package com.medicheck.BusinessLogic.Users.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseModel {
    private String user;
    private String message;
    private String Authorization;
}
