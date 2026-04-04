package com.hms.controller.api;

import com.hms.dto.view.prescription.PrescriptionDTO;
import com.hms.service.module.prescription.PrescriptionModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionApiController {

    @Autowired
    private PrescriptionModuleService prescriptionModuleService;

    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionModuleService.getAllPrescriptions());
    }

    @GetMapping("/by-patient")
    public ResponseEntity<List<PrescriptionDTO>> byPatient(
            @RequestParam Integer patientId) {
        return ResponseEntity.ok(
                prescriptionModuleService.getPrescriptionsByPatient(patientId));
    }

    @GetMapping("/by-physician")
    public ResponseEntity<List<PrescriptionDTO>> byPhysician(
            @RequestParam Integer physicianId) {
        return ResponseEntity.ok(
                prescriptionModuleService.getPrescriptionsByPhysician(physicianId));
    }

    @GetMapping("/by-appointment")
    public ResponseEntity<List<PrescriptionDTO>> byAppointment(
            @RequestParam Integer appointmentId) {
        return ResponseEntity.ok(
                prescriptionModuleService.getPrescriptionsByAppointment(appointmentId));
    }
}