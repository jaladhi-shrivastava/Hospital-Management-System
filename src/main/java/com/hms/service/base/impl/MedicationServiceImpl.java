package com.hms.service.base.impl;

import com.hms.entity.Medication;
import com.hms.repository.MedicationRepository;
import com.hms.service.base.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository repository;

    public Medication addMedication(Medication medication) {
        return repository.save(medication);
    }

    public List<Medication> getAllMedications() {
        return repository.findAll();
    }

    public Medication getMedicationById(Integer code) {
        return repository.findById(code).orElse(null);
    }

    public void deleteMedication(Integer code) {
        repository.deleteById(code);
    }
}