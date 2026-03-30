package com.hms.controller.api;

import com.hms.entity.Patient;
import com.hms.entity.Physician;
import com.hms.entity.TrainedIn;
import com.hms.service.module.physician.PhysicianModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhysicianApiController {

    @Autowired
    private PhysicianModuleService physicianModuleService;

    // GET /api/physicians/certification-expiring
    // Returns TrainedIn records expiring within the current calendar month
    // Each record carries the Physician and Procedures (treatment) objects
    @GetMapping("/api/physicians/certification-expiring")
    public ResponseEntity<List<TrainedIn>> getCertificationExpiring() {
        return ResponseEntity.ok(
                physicianModuleService.getPhysiciansCertifications()
        );
    }

    // GET /api/physicians/most-busy
    // Returns the single Physician with the highest appointment count
    @GetMapping("/api/physicians/most-busy")
    public ResponseEntity<Physician> getMostBusy() {
        Physician physician = physicianModuleService.getMostBusyPhysician();
        if (physician == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(physician);
    }

    // GET /api/physicians/{id}/patients
    // Returns all distinct Patient records who have appointments with this physician
    @GetMapping("/api/physicians/{id}/patients")
    public ResponseEntity<List<Patient>> getPatientsByPhysician(@PathVariable Integer id) {
        return ResponseEntity.ok(
                physicianModuleService.getPatientsByPhysician(id)
        );
    }

    // GET /api/procedures/{id}/certified-doctors
    // Returns all TrainedIn records for the given procedure code
    // Each record carries the Physician certified for that procedure
    @GetMapping("/api/procedures/{id}/certified-doctors")
    public ResponseEntity<List<TrainedIn>> getCertifiedDoctors(@PathVariable Integer id) {
        return ResponseEntity.ok(
                physicianModuleService.getCertifiedDoctorsForProcedure(id)
        );
    }
}
