package com.medicheck.Utils.Predictor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PredictionResultModel {

    private String disease;

    private double score;

}
