package com.medicheck.BusinessLogic.Diagnosis.model;


import com.medicheck.BusinessLogic.DiseaseSymptom.Entity.Severity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.io.Serializable;

@Data
public class SymptomItem implements Serializable{

    @NotNull
    @NotEmpty
    private String symptom;

    @NotNull
    @NotEmpty
    private Severity severity;
}
