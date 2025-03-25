package com.medicheck.BusinessLogic.Users.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class DoctorApplicationRequest {

    @NotEmpty
    @NotNull
    @Size(min = 20,max = 100000,message = "Please Write cover letter more than 20 characters")
    private String coverLetter;

}
