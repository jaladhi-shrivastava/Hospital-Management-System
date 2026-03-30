package com.hms.module.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/physicians")
public class PhysicianViewController {

    @Autowired
    private PhysicianModuleService physicianModuleService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute(
                "mostBusy",
                physicianModuleService.getMostBusyPhysician()
        );
        model.addAttribute(
                "expiringCerts",
                physicianModuleService.getPhysiciansCertifications()
        );
        return "physician/dashboard";  

    }

    @GetMapping("/{id}/patients")
    public String patientsByPhysician(@PathVariable Integer id, Model model) {
        model.addAttribute("patients",
                physicianModuleService.getPatientsByPhysician(id));

        model.addAttribute("physicianId", id);

        return "patients";
    }

    @GetMapping("/procedures/{id}/certified-doctors")
    public String certifiedDoctors(@PathVariable Integer id, Model model) {
        model.addAttribute("certifiedDoctors",
                physicianModuleService.getCertifiedDoctorsForProcedure(id));

        model.addAttribute("procedureCode", id);

        return "certified-doctors";
    }
}