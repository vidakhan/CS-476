package com.medicheck.BusinessLogic.Diagnosis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;

@Data
public class DiagnosisRequest implements Serializable {

    private HashSet<SymptomItem> symptoms;

}
