package com.hms.service.module.patient;

import com.hms.dto.view.patient.AdmittedPatientDTO;
import com.hms.dto.view.patient.RecentProcedureDTO;
import com.hms.entity.Stay;
import com.hms.entity.Undergoes;
import com.hms.repository.StayRepository;
import com.hms.repository.UndergoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientModuleServiceImpl implements PatientModuleService {

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private UndergoesRepository undergoesRepository;

    // GET /api/patients/currently-admitted
    // Maps each active Stay to AdmittedPatientDTO
    @Override
    @Transactional(readOnly = true)
    public List<AdmittedPatientDTO> getCurrentlyAdmittedPatients() {
        List<Stay> stays = stayRepository.findActiveStays();
        return stays.stream()
                .map(s -> new AdmittedPatientDTO(
                        s.getPatient() != null ? s.getPatient().getSsn() : null,
                        s.getPatient() != null ? s.getPatient().getName() : null,
                        s.getPatient() != null ? s.getPatient().getPhone() : null,
                        s.getPatient() != null ? s.getPatient().getAddress() : null,
                        s.getPatient() != null && s.getPatient().getPcp() != null
                                ? s.getPatient().getPcp().getEmployeeId() : null,
                        s.getPatient() != null && s.getPatient().getPcp() != null
                                ? s.getPatient().getPcp().getName() : null,
                        s.getStayId(),
                        s.getStayStart(),
                        s.getStayEnd(),
                        s.getRoom() != null ? s.getRoom().getRoomNumber() : null,
                        s.getRoom() != null ? s.getRoom().getRoomType() : null
                ))
                .toList();
    }

    // GET /api/patients/recent-procedures
    // Maps each Undergoes from last 30 days to RecentProcedureDTO
    @Override
    @Transactional(readOnly = true)
    public List<RecentProcedureDTO> getRecentProcedures() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        List<Undergoes> list = undergoesRepository.findRecentUndergoes(thirtyDaysAgo);
        return list.stream()
                .map(u -> new RecentProcedureDTO(
                        u.getId().getPatient(),
                        u.getId().getProcedures(),
                        u.getId().getStay(),
                        u.getId().getDateUndergoes(),
                        u.getPatient() != null ? u.getPatient().getName() : null,
                        u.getProcedures() != null ? u.getProcedures().getName() : null,
                        u.getProcedures() != null ? u.getProcedures().getCost() : null,
                        u.getPhysician() != null ? u.getPhysician().getEmployeeId() : null,
                        u.getPhysician() != null ? u.getPhysician().getName() : null,
                        u.getAssistingNurse() != null ? u.getAssistingNurse().getEmployeeId() : null,
                        u.getAssistingNurse() != null ? u.getAssistingNurse().getName() : null
                ))
                .toList();
    }
}