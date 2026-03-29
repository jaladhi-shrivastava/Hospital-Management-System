package com.hms.module.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    private AdminModuleService adminModuleService;

    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalRevenue", adminModuleService.getTotalRevenue());
        model.addAttribute("doctorCountPerDept", adminModuleService.getDoctorCountPerDepartment());
        return "admin/dashboard";
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