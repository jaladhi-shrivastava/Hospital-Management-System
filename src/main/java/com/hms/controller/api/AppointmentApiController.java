package com.hms.controller.api;

import com.hms.dto.view.appointment.NurseOnCallDTO;
import com.hms.dto.view.appointment.OccupiedRoomDTO;
import com.hms.service.module.appointment.AppointmentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentApiController {

    @Autowired
    private AppointmentModuleService appointmentModuleService;

    @GetMapping("/occupied")
    public ResponseEntity<List<OccupiedRoomDTO>> getOccupiedRooms() {
        return ResponseEntity.ok(appointmentModuleService.getOccupiedRooms());
    }

    @GetMapping("/nurses-on-call")
    public ResponseEntity<List<NurseOnCallDTO>> getNursesOnCall() {
        return ResponseEntity.ok(appointmentModuleService.getNursesOnCall());
    }
}