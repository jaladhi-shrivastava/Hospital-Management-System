package com.hms.module.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/physicians")
public class PhysicianViewController {

    @Autowired
    private PhysicianModuleService physicianModuleService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("mostBusy",
                physicianModuleService.getMostBusyPhysician());
        model.addAttribute("expiringCerts",
                physicianModuleService.getPhysiciansWithExpiringCertifications());
        return "physician/dashboard";  // → templates/physician/dashboard.html
    }

    @GetMapping("/{id}/patients")
    public String patientsByPhysician(@PathVariable Integer id, Model model) {
        model.addAttribute("patients",
                physicianModuleService.getPatientsByPhysician(id));
        model.addAttribute("physicianId", id);
        return "physician/patients";  // → templates/physician/patients.html
    }

    @GetMapping("/procedures/{id}/certified-doctors")
    public String certifiedDoctors(@PathVariable Integer id, Model model) {
        model.addAttribute("certifiedDoctors",
                physicianModuleService.getCertifiedDoctorsForProcedure(id));
        model.addAttribute("procedureCode", id);
        return "physician/certified-doctors";  // → templates/physician/certified-doctors.html
    }
}
