package com.hms.service.impl;

import com.hms.entity.Prescribes;
import com.hms.entity.PrescribesId;
import com.hms.repository.PrescribesRepository;
import com.hms.service.PrescribesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescribesServiceImpl implements PrescribesService {

    @Autowired
    private PrescribesRepository repository;

    @Override
    public Prescribes addPrescription(Prescribes p) {
        return repository.save(p);
    }

    @Override
    public List<Prescribes> getAllPrescriptions() {
        return repository.findAll();
    }

    @Override
    public List<Prescribes> getByPatient(Integer patientId) {
        return repository.findByPatientSsn(patientId);
    }

    @Override
    public List<Prescribes> getByPhysician(Integer physicianId) {
        return repository.findByPhysicianId(physicianId);
    }

    @Override
    public void deletePrescription(PrescribesId id) {
        repository.deleteById(id);
    }
}