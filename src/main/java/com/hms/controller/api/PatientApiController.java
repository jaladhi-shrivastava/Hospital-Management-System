package com.hms.controller.api;

import com.hms.entity.Stay;
import com.hms.entity.Undergoes;
import com.hms.service.module.patient.PatientModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientApiController {

    @Autowired
    private PatientModuleService patientModuleService;



    @GetMapping("/currently-admitted")
    public ResponseEntity<List<Stay>> getCurrentlyAdmitted() {
        List<Stay> result = patientModuleService.getCurrentlyAdmittedPatients();
        return ResponseEntity.ok(result);
    }



    @GetMapping("/recent-procedures")
    public ResponseEntity<List<Undergoes>> getRecentProcedures() {
        List<Undergoes> result = patientModuleService.getRecentProcedures();
        return ResponseEntity.ok(result);
    }
}
