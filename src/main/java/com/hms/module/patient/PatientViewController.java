package com.hms.module.patient;

import com.hms.entity.Patient;
import com.hms.entity.Stay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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