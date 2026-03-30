package com.hms.service.module.patient;

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

    // Uses JOIN FETCH via findActiveStays — patient and room are loaded
    @Override
    @Transactional(readOnly = true)
    public List<Stay> getCurrentlyAdmittedPatients() {
        return stayRepository.findActiveStays();
    }

    // Uses JOIN FETCH via findRecentUndergoes — all associations loaded
    @Override
    @Transactional(readOnly = true)
    public List<Undergoes> getRecentProcedures() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        return undergoesRepository.findRecentUndergoes(thirtyDaysAgo);
    }
}