package com.hms.controller;

import com.hms.entity.Patient;
import com.hms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{ssn}")
    public Patient getPatientById(@PathVariable Integer ssn) {
        return patientService.getPatientById(ssn);
    }

    @PutMapping("/{ssn}")
    public Patient updatePatient(@PathVariable Integer ssn, @RequestBody Patient patient) {
        return patientService.updatePatient(ssn, patient);
    }

    @DeleteMapping("/{ssn}")
    public String deletePatient(@PathVariable Integer ssn) {
        patientService.deletePatient(ssn);
        return "Patient deleted successfully!";
    }
}