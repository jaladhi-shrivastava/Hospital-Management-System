package com.hms.service.module.appointment;

import com.hms.dto.view.appointment.NurseOnCallDTO;
import com.hms.dto.view.appointment.OccupiedRoomDTO;
import com.hms.entity.Appointment;

import java.util.List;

public interface AppointmentModuleService {

    // GET /api/rooms/occupied
    List<OccupiedRoomDTO> getOccupiedRooms();

    // GET /api/nurses/on-call
    List<NurseOnCallDTO> getNursesOnCall();

    // Used internally by view controller — returns raw entity for Thymeleaf
    List<Appointment> getAppointmentsByPhysician(Integer physicianId);
}