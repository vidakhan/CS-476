package com.medicheck.BusinessLogic.Diagnosis.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;

@Data
public class DoctorDiagnosisRequest {

    @NotNull
    @NotEmpty
    private HashSet<SymptomItem> symptoms;

    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String description;

}
