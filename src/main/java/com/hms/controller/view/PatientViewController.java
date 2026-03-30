package com.hms.controller.view;

<<<<<<< HEAD:src/main/java/com/hms/module/patient/PatientViewController.java
import com.hms.entity.Patient;
import com.hms.entity.Stay;
=======
import com.hms.service.module.patient.PatientModuleService;
>>>>>>> origin/main:src/main/java/com/hms/controller/view/PatientViewController.java
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