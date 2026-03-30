package com.hms.controller.view;

import com.hms.service.module.appointment.AppointmentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
