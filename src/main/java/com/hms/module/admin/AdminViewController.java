package com.hms.module.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    private AdminModuleService adminModuleService;

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalRevenue", adminModuleService.getTotalRevenue());
        model.addAttribute("doctorCountPerDept", adminModuleService.getDoctorCountPerDepartment());
        return "AdminDashboard"; // matches templates/AdminDashboard.html
    }

    @GetMapping("/procedures")
    public String proceduresByPatient(
            @RequestParam(required = false) Integer patientId,
            Model model) {

        if (patientId != null) {
            model.addAttribute("procedures", adminModuleService.getProceduresByPatient(patientId));
            model.addAttribute("patientId", patientId);
        }
        return "Procedures";
    }

    @GetMapping("/appointments")
    public String appointmentsDashboard(Model model) {

        model.addAttribute("occupiedRooms", adminModuleService.getProceduresByPatient(1));
        model.addAttribute("nursesOnCall", adminModuleService.getProceduresByPatient(1));

        return "AppointmentDashboard";
    }
    }
