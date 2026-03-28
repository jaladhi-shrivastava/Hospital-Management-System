package com.hms.module.physician;

import com.hms.entity.Patient;
import com.hms.entity.Physician;
import com.hms.entity.TrainedIn;
import com.hms.repository.AppointmentRepository;
import com.hms.repository.TrainedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhysicianModuleServiceImpl implements PhysicianModuleService {

    @Autowired
    private TrainedInRepository trainedInRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<TrainedIn> getPhysiciansWithExpiringCertifications() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfMonth = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime endOfMonth = now.withDayOfMonth(now.toLocalDate().lengthOfMonth())
                .withHour(23).withMinute(59).withSecond(59);

        return trainedInRepository.findAll()
                .stream()
                .filter(t -> t.getCertificationExpires() != null
                        && !t.getCertificationExpires().isBefore(startOfMonth)
                        && !t.getCertificationExpires().isAfter(endOfMonth))
                .toList();
    }

    @Override
    public Physician getMostBusyPhysician() {
        List<Object[]> results = appointmentRepository.findPhysicianAppointmentCounts();
        if (results.isEmpty()) return null;
        return (Physician) results.get(0)[0];
    }

    @Override
    public List<Patient> getPatientsByPhysician(Integer physicianId) {
        return appointmentRepository.findPatientsByPhysicianId(physicianId);
    }

    @Override
    public List<TrainedIn> getCertifiedDoctorsForProcedure(Integer procedureCode) {
        return trainedInRepository.findById_Treatment(procedureCode);
    }
}
