package com.hms.service.base.impl;

import com.hms.entity.Prescribes;
import com.hms.entity.PrescribesId;
import com.hms.repository.PrescribesRepository;
import com.hms.service.base.PrescribesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescribesServiceImpl implements PrescribesService {

    @Autowired
    private PrescribesRepository prescribesRepository;

    @Override
    public Prescribes savePrescribes(Prescribes prescribes) {
        return prescribesRepository.save(prescribes);
    }

    @Override
    public List<Prescribes> getAllPrescribes() {
        return prescribesRepository.findAll();
    }

    @Override
    public Prescribes getPrescribesById(PrescribesId id) {
        return prescribesRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePrescribes(PrescribesId id) {
        prescribesRepository.deleteById(id);
    }


    @Override
    public List<Prescribes> getPrescribesByPatient(Integer patientSsn) {
        return prescribesRepository.findByPatientSsn(patientSsn);
    }


    @Override
    public List<Prescribes> getPrescribesByPhysician(Integer physicianId) {
        return prescribesRepository.findByPhysicianId(physicianId);
    }


    @Override
    public List<Prescribes> getPrescribesByAppointment(Integer appointmentId) {
        return prescribesRepository.findByAppointmentId(appointmentId);
    }
}