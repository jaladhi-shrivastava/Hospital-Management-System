package com.hms.controller.api;

import com.hms.dto.view.physician.CertifiedDoctorDTO;
import com.hms.dto.view.physician.ExpiringCertificationDTO;
import com.hms.dto.view.physician.MostBusyPhysicianDTO;
import com.hms.dto.view.physician.PhysicianPatientDTO;
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


    @GetMapping("/api/physicians/most-busy")
    public ResponseEntity<MostBusyPhysicianDTO> getMostBusy() {
        MostBusyPhysicianDTO result = physicianModuleService.getMostBusyPhysician();
        if (result == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/api/physicians/certification-expiring")
    public ResponseEntity<List<ExpiringCertificationDTO>> getCertificationExpiring() {
        return ResponseEntity.ok(physicianModuleService.getPhysiciansCertifications());
    }


    @GetMapping("/api/physicians/{id}/patients")
    public ResponseEntity<List<PhysicianPatientDTO>> getPatientsByPhysician(
            @PathVariable Integer id) {
        return ResponseEntity.ok(physicianModuleService.getPatientsByPhysician(id));
    }


    @GetMapping("/api/procedures/{id}/certified-doctors")
    public ResponseEntity<List<CertifiedDoctorDTO>> getCertifiedDoctors(
            @PathVariable Integer id) {
        return ResponseEntity.ok(physicianModuleService.getCertifiedDoctorsForProcedure(id));
    }
}