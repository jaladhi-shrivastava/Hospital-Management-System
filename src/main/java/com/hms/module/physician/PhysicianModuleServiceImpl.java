package com.hms.module.physician;

import com.hms.entity.Patient;
import com.hms.entity.Physician;
import com.hms.entity.TrainedIn;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.TrainedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhysicianModuleServiceImpl implements PhysicianModuleService {

    @Autowired
    private TrainedInRepository trainedInRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TrainedIn> getPhysiciansCertifications() {
        return trainedInRepository.findAllWithDetails();
    }

    @Override
    @Transactional(readOnly = true)
    public Physician getMostBusyPhysician() {
        List<Object[]> results = appointmentRepository.findPhysicianAppointmentCounts();
        if (results == null || results.isEmpty()) return null;

        Object first = results.get(0)[0];
        if (first instanceof Physician) {
            return (Physician) first;
        }
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Patient> getPatientsByPhysician(Integer physicianId) {
        return appointmentRepository.findPatientsByPhysicianId(physicianId);
    }


    @Override
    @Transactional(readOnly = true)
    public List<TrainedIn> getCertifiedDoctorsForProcedure(Integer procedureCode) {
        return trainedInRepository.findById_Treatment(procedureCode);
    }
}