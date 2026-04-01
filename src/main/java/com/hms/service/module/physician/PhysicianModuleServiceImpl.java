package com.hms.service.module.physician;

import com.hms.dto.view.physician.CertifiedDoctorDTO;
import com.hms.dto.view.physician.ExpiringCertificationDTO;
import com.hms.dto.view.physician.MostBusyPhysicianDTO;
import com.hms.dto.view.physician.PhysicianPatientDTO;
import com.hms.entity.Patient;
import com.hms.entity.Physician;
import com.hms.entity.TrainedIn;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.TrainedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhysicianModuleServiceImpl implements PhysicianModuleService {

    @Autowired
    private TrainedInRepository trainedInRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    // GET /api/physicians/most-busy
    // Gets grouped appointment counts, maps first result to DTO including count
    @Override
    @Transactional(readOnly = true)
    public MostBusyPhysicianDTO getMostBusyPhysician() {
        List<Object[]> results = appointmentRepository.findPhysicianAppointmentCounts();
        if (results == null || results.isEmpty()) return null;

        Object[] top = results.get(0);
        Physician physician = (Physician) top[0];
        Long count = (Long) top[1];

        return new MostBusyPhysicianDTO(
                physician.getEmployeeId(),
                physician.getName(),
                physician.getPosition(),
                count
        );
    }

    // GET /api/physicians/certification-expiring
    // Returns all certifications (broadened from monthly filter due to historical data)
    @Override
    @Transactional(readOnly = true)
    public List<ExpiringCertificationDTO> getPhysiciansCertifications() {
        return trainedInRepository.findAllWithDetails()
                .stream()
                .map(t -> new ExpiringCertificationDTO(
                        t.getId().getPhysician(),
                        t.getId().getTreatment(),
                        t.getPhysician() != null ? t.getPhysician().getName() : null,
                        t.getPhysician() != null ? t.getPhysician().getPosition() : null,
                        t.getTreatment() != null ? t.getTreatment().getName() : null,
                        t.getTreatment() != null ? t.getTreatment().getCost() : null,
                        t.getCertificationDate(),
                        t.getCertificationExpires()
                ))
                .toList();
    }

    // GET /api/physicians/{id}/patients
    // Maps each Patient to PhysicianPatientDTO
    @Override
    @Transactional(readOnly = true)
    public List<PhysicianPatientDTO> getPatientsByPhysician(Integer physicianId) {
        List<Patient> patients = appointmentRepository.findPatientsByPhysicianId(physicianId);
        if (patients.isEmpty()) {
            throw new com.hms.exception.ResourceNotFoundException(
                    "No patients found for physician ID: " + physicianId);
        }
        return patients.stream()
                .map(p -> new PhysicianPatientDTO(
                        p.getSsn(),
                        p.getName(),
                        p.getPhone(),
                        p.getAddress(),
                        p.getInsuranceId(),
                        p.getPcp() != null ? p.getPcp().getEmployeeId() : null,
                        p.getPcp() != null ? p.getPcp().getName() : null
                ))
                .toList();
    }

    // GET /api/procedures/{id}/certified-doctors
    // Maps each TrainedIn to CertifiedDoctorDTO
    @Override
    @Transactional(readOnly = true)
    public List<CertifiedDoctorDTO> getCertifiedDoctorsForProcedure(Integer procedureCode) {
        List<TrainedIn> results = trainedInRepository.findById_Treatment(procedureCode);
        if (results.isEmpty()) {
            throw new com.hms.exception.ResourceNotFoundException(
                    "No certified doctors found for procedure code: " + procedureCode);
        }
        return results.stream()
                .map(t -> new CertifiedDoctorDTO(
                        t.getId().getPhysician(),
                        t.getId().getTreatment(),
                        t.getPhysician() != null ? t.getPhysician().getName() : null,
                        t.getPhysician() != null ? t.getPhysician().getPosition() : null,
                        t.getTreatment() != null ? t.getTreatment().getName() : null,
                        t.getCertificationDate(),
                        t.getCertificationExpires()
                ))
                .toList();
    }
}