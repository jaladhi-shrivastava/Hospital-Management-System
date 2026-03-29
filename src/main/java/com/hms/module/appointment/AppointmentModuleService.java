package com.hms.module.appointment;

import com.hms.entity.Appointment;
import com.hms.entity.OnCall;
import com.hms.entity.Stay;

import java.util.List;

public interface AppointmentModuleService {

    // All appointments for a specific physician — used for display on Thymeleaf page
    List<Appointment> getAppointmentsByPhysician(Integer physicianId);

    // GET /api/rooms/occupied — rooms with active stays
    List<Stay> getOccupiedRooms();

    // GET /api/nurses/on-call — nurses currently on duty
    List<OnCall> getNursesOnCall();
}
