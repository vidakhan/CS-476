package com.medicheck.BusinessLogic.Symptoms.Controller;


import com.medicheck.BusinessLogic.Symptoms.Entity.Symptom;
import com.medicheck.BusinessLogic.Symptoms.Service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/symptoms")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @GetMapping
    public ResponseEntity<List<Symptom>> getAllSymptoms() {
        return ResponseEntity.ok(symptomService.getAllSymptoms());
    }

    @PostMapping
    public ResponseEntity<String> createSymptom(@RequestBody Symptom symptom) {
        symptomService.saveSymptom(symptom);
        return ResponseEntity.ok("Symptom created successfully");
    }
}