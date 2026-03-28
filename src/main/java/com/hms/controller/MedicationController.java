package com.hms.controller;

import com.hms.entity.Medication;
import com.hms.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationService service;

    @PostMapping
    public Medication addMedication(@RequestBody Medication medication) {
        return service.addMedication(medication);
    }

    @GetMapping
    public List<Medication> getAllMedications() {
        return service.getAllMedications();
    }

    @GetMapping("/{code}")
    public Medication getMedication(@PathVariable Integer code) {
        return service.getMedicationById(code);
    }

    @DeleteMapping("/{code}")
    public String deleteMedication(@PathVariable Integer code) {
        service.deleteMedication(code);
        return "Deleted successfully";
    }
}