package com.hms.controller.api;

import com.hms.service.module.appointment.AppointmentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppointmentApiController {
    @Autowired
    private AppointmentModuleService appointmentModuleService;

    @GetMapping("/api/rooms/occupied")
    public ResponseEntity<?> getOccupiedRooms() {
        return ResponseEntity.ok(appointmentModuleService.getOccupiedRooms());
    }

    @GetMapping("/api/nurses/on-call")
    public ResponseEntity<?> getNursesOnCall() {
        return ResponseEntity.ok(appointmentModuleService.getNursesOnCall());
    }
}
