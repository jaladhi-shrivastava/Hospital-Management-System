package com.hms.controller.api;

import com.hms.dto.view.patient.AdmittedPatientDTO;
import com.hms.dto.view.patient.RecentProcedureDTO;
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
    public ResponseEntity<List<AdmittedPatientDTO>> getCurrentlyAdmitted() {
        return ResponseEntity.ok(patientModuleService.getAdmittedPatients());
    }

    @GetMapping("/recent-procedures")
    public ResponseEntity<List<RecentProcedureDTO>> getRecentProcedures() {
        return ResponseEntity.ok(patientModuleService.getRecentProcedures());
    }
}