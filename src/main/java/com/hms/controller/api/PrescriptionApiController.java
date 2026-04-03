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

    // GET /api/prescriptions
    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionModuleService.getAllPrescriptions());
    }

    // GET /api/prescriptions/by-patient?patientId={ssn}
    @GetMapping("/by-patient")
    public ResponseEntity<List<PrescriptionDTO>> byPatient(
            @RequestParam Integer patientId) {
        return ResponseEntity.ok(
                prescriptionModuleService.getPrescriptionsByPatient(patientId));
    }

    // GET /api/prescriptions/by-physician?physicianId={id}
    @GetMapping("/by-physician")
    public ResponseEntity<List<PrescriptionDTO>> byPhysician(
            @RequestParam Integer physicianId) {
        return ResponseEntity.ok(
                prescriptionModuleService.getPrescriptionsByPhysician(physicianId));
    }

    // GET /api/prescriptions/by-appointment?appointmentId={id}
    @GetMapping("/by-appointment")
    public ResponseEntity<List<PrescriptionDTO>> byAppointment(
            @RequestParam Integer appointmentId) {
        return ResponseEntity.ok(
                prescriptionModuleService.getPrescriptionsByAppointment(appointmentId));
    }
}