package com.hms.service.module.prescription;

import com.hms.dto.view.prescription.PrescriptionDTO;
import com.hms.entity.Prescribes;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repository.PrescribesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrescriptionModuleServiceImpl implements PrescriptionModuleService {

    @Autowired
    private PrescribesRepository prescribesRepository;

    private PrescriptionDTO toDTO(Prescribes p) {
        return new PrescriptionDTO(
                p.getId().getPhysician(),
                p.getPhysician() != null ? p.getPhysician().getName() : null,
                p.getPhysician() != null ? p.getPhysician().getPosition() : null,
                p.getId().getPatient(),
                p.getPatient() != null ? p.getPatient().getName() : null,
                p.getId().getMedication(),
                p.getMedication() != null ? p.getMedication().getName() : null,
                p.getMedication() != null ? p.getMedication().getBrand() : null,
                p.getId().getDate(),
                p.getDose(),
                p.getAppointment() != null ? p.getAppointment().getAppointmentId() : null
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrescriptionDTO> getAllPrescriptions() {
        return prescribesRepository.findAllWithDetails()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrescriptionDTO> getPrescriptionsByPatient(Integer patientSsn) {
        List<Prescribes> list = prescribesRepository.findByPatientSsn(patientSsn);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No prescriptions found for patient SSN: " + patientSsn);
        }
        return list.stream().map(this::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrescriptionDTO> getPrescriptionsByPhysician(Integer physicianId) {
        List<Prescribes> list = prescribesRepository.findByPhysicianId(physicianId);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No prescriptions found for physician ID: " + physicianId);
        }
        return list.stream().map(this::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrescriptionDTO> getPrescriptionsByAppointment(Integer appointmentId) {
        List<Prescribes> list = prescribesRepository.findByAppointmentId(appointmentId);
        if (list.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No prescriptions found for appointment ID: " + appointmentId);
        }
        return list.stream().map(this::toDTO).toList();
    }
}