package com.hms.module;

import com.hms.entity.Prescribes;
import com.hms.repository.PrescribesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionModuleServiceImpl implements PrescriptionModuleService {

    @Autowired
    private PrescribesRepository prescribesRepository;

    // All prescriptions for a patient by their SSN
    @Override
    public List<Prescribes> getPrescriptionsByPatient(Integer patientSsn) {
        return prescribesRepository.findByPatientSsn(patientSsn);
    }

    // All prescriptions written by a physician
    @Override
    public List<Prescribes> getPrescriptionsByPhysician(Integer physicianId) {
        return prescribesRepository.findByPhysicianId(physicianId);
    }

    // All prescriptions for a specific appointment
    @Override
    public List<Prescribes> getPrescriptionsByAppointment(Integer appointmentId) {
        return prescribesRepository.findByAppointmentId(appointmentId);
    }
}
