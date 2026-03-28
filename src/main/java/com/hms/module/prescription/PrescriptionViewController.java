package com.hms.module.prescription;

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

    // GET /prescriptions/dashboard
    // Landing page — user can search by patient, physician, or appointment
    @GetMapping("/dashboard")
    public String dashboard() {
        return "prescription/dashboard";  // → templates/prescription/dashboard.html
    }

    // GET /prescriptions/by-patient?patientId={ssn}
    // Shows all prescriptions for a given patient
    @GetMapping("/by-patient")
    public String byPatient(
            @RequestParam(required = false) Integer patientId,
            Model model) {

        if (patientId != null) {
            model.addAttribute("prescriptions",
                    prescriptionModuleService.getPrescriptionsByPatient(patientId));
            model.addAttribute("patientId", patientId);
        }
        return "prescription/by-patient";  // → templates/prescription/by-patient.html
    }

    // GET /prescriptions/by-physician?physicianId={id}
    // Shows all prescriptions written by a given physician
    @GetMapping("/by-physician")
    public String byPhysician(
            @RequestParam(required = false) Integer physicianId,
            Model model) {

        if (physicianId != null) {
            model.addAttribute("prescriptions",
                    prescriptionModuleService.getPrescriptionsByPhysician(physicianId));
            model.addAttribute("physicianId", physicianId);
        }
        return "prescription/by-physician";  // → templates/prescription/by-physician.html
    }

    // GET /prescriptions/by-appointment?appointmentId={id}
    // Shows all prescriptions linked to a specific appointment
    @GetMapping("/by-appointment")
    public String byAppointment(
            @RequestParam(required = false) Integer appointmentId,
            Model model) {

        if (appointmentId != null) {
            model.addAttribute("prescriptions",
                    prescriptionModuleService.getPrescriptionsByAppointment(appointmentId));
            model.addAttribute("appointmentId", appointmentId);
        }
        return "prescription/by-appointment";  // → templates/prescription/by-appointment.html
    }
}
