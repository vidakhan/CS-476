package com.medicheck.BusinessLogic.Diseases.Controller;


import com.medicheck.BusinessLogic.Diseases.Entity.Disease;
import com.medicheck.BusinessLogic.Diseases.Service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diseases")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping
    public ResponseEntity<List<Disease>> getAllDiseases() {
        return ResponseEntity.ok(diseaseService.getAllDiseases());
    }

    @PostMapping
    public ResponseEntity<String> createDisease(@RequestBody Disease disease) {
        diseaseService.saveDisease(disease);
        return ResponseEntity.ok("Disease created successfully");
    }
}