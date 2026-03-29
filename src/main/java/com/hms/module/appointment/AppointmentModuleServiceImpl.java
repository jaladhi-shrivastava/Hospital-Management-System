package com.hms.module.appointment;

import com.hms.entity.Appointment;
import com.hms.entity.OnCall;
import com.hms.entity.Stay;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.OnCallRepository;
import com.hms.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentModuleServiceImpl implements AppointmentModuleService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private OnCallRepository onCallRepository;

    // All appointments for a physician — used on the Thymeleaf appointment page
    @Override
    public List<Appointment> getAppointmentsByPhysician(Integer physicianId) {
        return appointmentRepository.findByPhysicianId(physicianId);
    }

    // GET /api/rooms/occupied
    // Returns Stay records where stayEnd is null — room is still occupied
    @Override
    public List<Stay> getOccupiedRooms() {
        return stayRepository.findOccupiedRoomStays();
    }

    // GET /api/nurses/on-call
    // Returns OnCall records where now is between onCallStart and onCallEnd
    @Override
    public List<OnCall> getNursesOnCall() {
        return onCallRepository.findCurrentlyOnCall(LocalDateTime.now());
    }
}
