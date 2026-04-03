package com.hms.controller.view;

import com.hms.service.module.prescription.PrescriptionModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/prescriptions")
public class PrescriptionViewController {

    @Autowired
    private PrescriptionModuleService prescriptionModuleService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("prescriptions",
                prescriptionModuleService.getAllPrescriptions());
        return "prescriptions/dashboard";
    }

    @GetMapping("/by-patient")
    public String byPatient(@RequestParam(required = false) Integer patientId,
                            Model model) {
        if (patientId != null) {
            model.addAttribute("prescriptions",
                    prescriptionModuleService.getPrescriptionsByPatient(patientId));
            model.addAttribute("searchId", patientId);
            model.addAttribute("searchType", "Patient SSN");
        }
        return "prescriptions/dashboard";
    }

    @GetMapping("/by-physician")
    public String byPhysician(@RequestParam(required = false) Integer physicianId,
                              Model model) {
        if (physicianId != null) {
            model.addAttribute("prescriptions",
                    prescriptionModuleService.getPrescriptionsByPhysician(physicianId));
            model.addAttribute("searchId", physicianId);
            model.addAttribute("searchType", "Physician ID");
        }
        return "prescriptions/dashboard";
    }

    @GetMapping("/by-appointment")
    public String byAppointment(@RequestParam(required = false) Integer appointmentId,
                                Model model) {
        if (appointmentId != null) {
            model.addAttribute("prescriptions",
                    prescriptionModuleService.getPrescriptionsByAppointment(appointmentId));
            model.addAttribute("searchId", appointmentId);
            model.addAttribute("searchType", "Appointment ID");
        }
        return "prescriptions/dashboard";
    }
}