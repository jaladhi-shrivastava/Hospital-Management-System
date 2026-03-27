package com.hms.service.impl;

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

    public Prescribes addPrescription(Prescribes p) {
        return repository.save(p);
    }

    public List<Prescribes> getAllPrescriptions() {
        return repository.findAll();
    }

    public List<Prescribes> getByPatient(Integer patientId) {
        return repository.findByIdPatient(patientId);
    }

    public List<Prescribes> getByPhysician(Integer physicianId) {
        return repository.findByIdPhysician(physicianId);
    }

    public void deletePrescription(PrescribesId id) {
        repository.deleteById(id);
    }
}