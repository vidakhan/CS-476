package com.medicheck;

import com.medicheck.Utils.Predictor.DiseasesPredictor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicheckProjectApplication {

	public static void main(String[] args) {
		DiseasesPredictor.initialize();
		SpringApplication.run(MedicheckProjectApplication.class, args);
	}

}
