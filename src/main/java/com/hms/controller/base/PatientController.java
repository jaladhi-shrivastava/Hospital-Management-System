package com.hms.controller.base;

import com.hms.entity.Patient;
import com.hms.service.base.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Integer ssn) {
        return patientService.getPatientById(ssn);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable("id") Integer ssn) {
        patientService.deletePatient(ssn);
        return "Patient deleted successfully";
    }
}