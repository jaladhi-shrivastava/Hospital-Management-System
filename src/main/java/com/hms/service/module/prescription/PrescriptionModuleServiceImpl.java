package com.hms.service.module;

import com.hms.entity.Prescribes;
import com.hms.service.module.prescription.PrescriptionModuleService;
import com.hms.repository.PrescribesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionModuleServiceImpl implements PrescriptionModuleService {

    @Autowired
    private PrescribesRepository prescribesRepository;

    @Override
    public List<Prescribes> getPrescriptionsByPatient(Integer patientSsn) {
        return prescribesRepository.findByPatientSsn(patientSsn);
    }

    @Override
    public List<Prescribes> getPrescriptionsByPhysician(Integer physicianId) {
        return prescribesRepository.findByPhysicianId(physicianId);
    }

    @Override
    public List<Prescribes> getPrescriptionsByAppointment(Integer appointmentId) {
        return prescribesRepository.findByAppointmentId(appointmentId);
    }
}
