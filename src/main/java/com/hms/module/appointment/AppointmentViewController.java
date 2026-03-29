package com.hms.module.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/appointments")
public class AppointmentViewController {

    @Autowired
    private AppointmentModuleService appointmentModuleService;

    // GET /appointments/dashboard
    // Shows: occupied rooms + nurses currently on call
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("occupiedRooms",
                appointmentModuleService.getOccupiedRooms());
        model.addAttribute("nursesOnCall",
                appointmentModuleService.getNursesOnCall());
        return "appointment/dashboard";  // → templates/appointment/dashboard.html
    }

    // GET /appointments/by-physician?physicianId={id}
    // Shows all appointments for a given physician
    @GetMapping("/by-physician")
    public String appointmentsByPhysician(
            @RequestParam(required = false) Integer physicianId,
            Model model) {

        if (physicianId != null) {
            model.addAttribute("appointments",
                    appointmentModuleService.getAppointmentsByPhysician(physicianId));
            model.addAttribute("physicianId", physicianId);
        }
        return "appointment/by-physician";  // → templates/appointment/by-physician.html
    }
}
