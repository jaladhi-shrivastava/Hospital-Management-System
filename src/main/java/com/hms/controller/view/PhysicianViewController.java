package com.hms.controller.view;

import com.hms.service.module.physician.PhysicianModuleService;
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

    // GET /physicians/dashboard
    // mostBusy is now MostBusyPhysicianDTO — update th:text in template accordingly
    // expiringCerts is now List<ExpiringCertificationDTO>
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("mostBusy",
                physicianModuleService.getMostBusyPhysician());
        model.addAttribute("expiringCerts",
                physicianModuleService.getPhysiciansCertifications());
        return "physician/dashboard";
    }

    // GET /physicians/{id}/patients
    // patients is now List<PhysicianPatientDTO>
    @GetMapping("/{id}/patients")
    public String patientsByPhysician(@PathVariable Integer id, Model model) {
        model.addAttribute("patients",
                physicianModuleService.getPatientsByPhysician(id));
        model.addAttribute("physicianId", id);
        return "physician/patients";
    }

    // GET /physicians/procedures/{id}/certified-doctors
    // certifiedDoctors is now List<CertifiedDoctorDTO>
    @GetMapping("/procedures/{id}/certified-doctors")
    public String certifiedDoctors(@PathVariable Integer id, Model model) {
        model.addAttribute("certifiedDoctors",
                physicianModuleService.getCertifiedDoctorsForProcedure(id));
        model.addAttribute("procedureCode", id);
        return "physician/certified-doctors";
    }
}