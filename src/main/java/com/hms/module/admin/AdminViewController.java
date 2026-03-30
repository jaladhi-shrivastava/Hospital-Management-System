package com.hms.module.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    private AdminModuleService adminModuleService;


    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";

    }

    // GET /admin/dashboard
    // Implements: GET /hospital/status (Thymeleaf-facing)
    // Passes: totalRevenue, doctorCountPerDept, hospitalStatus
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalRevenue",       adminModuleService.getTotalRevenue());
        model.addAttribute("doctorCountPerDept", adminModuleService.getDoctorCountPerDepartment());
        model.addAttribute("hospitalStatus",     adminModuleService.getHospitalStatus());
        return "admin/dashboard";  // → templates/admin/dashboard.html

    }


    @GetMapping("/procedures")
    public String proceduresByPatient(
            @RequestParam(required = false) Integer patientId,
            Model model) {

        if (patientId != null) {
            model.addAttribute("procedures", adminModuleService.getProceduresByPatient(patientId));
            model.addAttribute("patientId", patientId);
        }

        return "admin/procedures";

    }
}