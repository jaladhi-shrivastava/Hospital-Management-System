package com.hms.controller.api;

import com.hms.dto.view.admin.AdminDashboardDTO;
import com.hms.service.module.admin.AdminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {

    @Autowired
    private AdminModuleService adminModuleService;

    @GetMapping("/status")
    public ResponseEntity<AdminDashboardDTO> getHospitalStatus() {
        return ResponseEntity.ok(adminModuleService.getHospitalStatus());
    }

    @GetMapping("/revenue")
    public ResponseEntity<Double> getTotalRevenue() {
        return ResponseEntity.ok(adminModuleService.getTotalRevenue());
    }

    @GetMapping("/departments/doctor-count")
    public ResponseEntity<java.util.Map<String, Long>> getDoctorCountPerDepartment() {
        return ResponseEntity.ok(adminModuleService.getDoctorCountPerDepartment());
    }
}