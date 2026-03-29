package com.hms.module.patient;

import com.hms.entity.Stay;
import com.hms.entity.Undergoes;
import com.hms.repository.StayRepository;
import com.hms.repository.UndergoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientModuleServiceImpl implements PatientModuleService {

    @Autowired
    private StayRepository stayRepository;

    @Autowired
    private UndergoesRepository undergoesRepository;

    // GET /api/patients/currently-admitted
    // Delegates to StayRepository — finds stays where stayEnd IS NULL
    @Override
    public List<Stay> getCurrentlyAdmittedPatients() {
        return stayRepository.findActiveStays();
    }

    // GET /api/patients/recent-procedures
    // Finds all Undergoes records where dateUndergoes >= 30 days ago
    @Override
    public List<Undergoes> getRecentProcedures() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        return undergoesRepository.findRecentUndergoes(thirtyDaysAgo);
    }
}