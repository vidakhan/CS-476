package com.medicheck.BusinessLogic.DiseaseSymptom.Entity;


import com.medicheck.BusinessLogic.Symptoms.Entity.Symptom;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;

import javax.print.attribute.standard.Severity;


@Data
@Embeddable
public class DiseaseSymptom {

    private Symptom symptom;

    private Severity severity;


}
