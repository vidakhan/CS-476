package com.medicheck.BusinessLogic.Diagnosis.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class DoctorMakeDiagnosisRequest {

    @NotNull
    private UUID diagnosisId;

    @NotNull
    @NotEmpty
    private String findings;

    @NotNull
    @NotEmpty
    private String medication;


}
