package com.hms.service.module.appointment;

import com.hms.dto.view.appointment.NurseOnCallDTO;
import com.hms.dto.view.appointment.OccupiedRoomDTO;
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

    // GET /api/rooms/occupied
    // Maps each active Stay to OccupiedRoomDTO
    @Override
    @Transactional(readOnly = true)
    public List<OccupiedRoomDTO> getOccupiedRooms() {
        List<Stay> stays = stayRepository.findOccupiedRoomStays();
        return stays.stream()
                .map(s -> new OccupiedRoomDTO(
                        s.getRoom() != null ? s.getRoom().getRoomNumber() : null,
                        s.getRoom() != null ? s.getRoom().getRoomType() : null,
                        s.getRoom() != null && s.getRoom().getBlock() != null
                                ? s.getRoom().getBlock().getId().getBlockFloor() : null,
                        s.getRoom() != null && s.getRoom().getBlock() != null
                                ? s.getRoom().getBlock().getId().getBlockCode() : null,
                        s.getStayId(),
                        s.getStayStart(),
                        s.getStayEnd(),
                        s.getPatient() != null ? s.getPatient().getSsn() : null,
                        s.getPatient() != null ? s.getPatient().getName() : null
                ))
                .toList();
    }

    // GET /api/nurses/on-call
    // Maps each OnCall record to NurseOnCallDTO
    @Override
    @Transactional(readOnly = true)
    public List<NurseOnCallDTO> getNursesOnCall() {
        List<OnCall> onCalls = onCallRepository.findCurrentlyOnCall(LocalDateTime.now());
        return onCalls.stream()
                .map(o -> new NurseOnCallDTO(
                        o.getId().getNurse(),
                        o.getId().getBlockFloor(),
                        o.getId().getBlockCode(),
                        o.getNurse() != null ? o.getNurse().getName() : null,
                        o.getNurse() != null ? o.getNurse().getPosition() : null,
                        o.getNurse() != null ? o.getNurse().getRegistered() : null,
                        o.getOnCallStart(),
                        o.getOnCallEnd()
                ))
                .toList();
    }

    // Used by AppointmentViewController — returns raw Appointment entities for Thymeleaf
    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByPhysician(Integer physicianId) {
        return appointmentRepository.findByPhysicianId(physicianId);
    }
}