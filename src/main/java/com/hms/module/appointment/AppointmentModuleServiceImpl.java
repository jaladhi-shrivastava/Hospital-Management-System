package com.hms.module.appointment;

import com.hms.entity.Appointment;
import com.hms.entity.OnCall;
import com.hms.entity.Stay;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.OnCallRepository;
import com.hms.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // All appointments for a physician — patient, nurse, physician all JOIN FETCHed
    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByPhysician(Integer physicianId) {
        return appointmentRepository.findByPhysicianId(physicianId);
    }

    // GET /api/rooms/occupied — patient and room JOIN FETCHed in StayRepository
    @Override
    @Transactional(readOnly = true)
    public List<Stay> getOccupiedRooms() {
        return stayRepository.findOccupiedRoomStays();
    }

    // GET /api/nurses/on-call — nurse and block JOIN FETCHed in OnCallRepository
    @Override
    @Transactional(readOnly = true)
    public List<OnCall> getNursesOnCall() {
        return onCallRepository.findCurrentlyOnCall(LocalDateTime.now());
    }
}