package com.hms.module.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
public class PatientViewController {

    @Autowired
    private PatientModuleService patientModuleService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("admittedPatients",
                patientModuleService.getCurrentlyAdmittedPatients());

        model.addAttribute("recentProcedures",
                patientModuleService.getRecentProcedures());

        return "patient/dashboard";
    }
}