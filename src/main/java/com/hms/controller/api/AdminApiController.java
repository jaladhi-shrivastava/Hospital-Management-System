package com.hms.controller.api;

import com.hms.entity.Undergoes;
import com.hms.service.module.admin.AdminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminApiController {

    @Autowired
    private AdminModuleService adminModuleService;


    @GetMapping("/hospital/status")
    public ResponseEntity<Map<String, Object>> getHospitalStatus() {
        return ResponseEntity.ok(adminModuleService.getHospitalStatus());
    }


    @GetMapping("/api/reports/revenue")
    public ResponseEntity<Double> getTotalRevenue() {
        return ResponseEntity.ok(adminModuleService.getTotalRevenue());
    }

    @GetMapping("/procedures")
    public ResponseEntity<List<Undergoes>> getProceduresByPatient(
            @RequestParam Integer patientId) {
        return ResponseEntity.ok(adminModuleService.getProceduresByPatient(patientId));
    }


    @GetMapping("/api/departments/doctor-count")
    public ResponseEntity<Map<String, Long>> getDoctorCountPerDepartment() {
        return ResponseEntity.ok(adminModuleService.getDoctorCountPerDepartment());
    }




}
