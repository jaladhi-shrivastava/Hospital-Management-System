package com.hms.repository;

import com.hms.entity.Prescribes;
import com.hms.entity.PrescribesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescribesRepository extends JpaRepository<Prescribes, PrescribesId> {

    @Query("SELECT p FROM Prescribes p WHERE p.id.patient = :patientSsn")
    List<Prescribes> findByPatientSsn(@Param("patientSsn") Integer patientSsn);

    @Query("SELECT p FROM Prescribes p WHERE p.id.physician = :physicianId")
    List<Prescribes> findByPhysicianId(@Param("physicianId") Integer physicianId);

    @Query("SELECT p FROM Prescribes p WHERE p.appointment.appointmentId = :appointmentId")
    List<Prescribes> findByAppointmentId(@Param("appointmentId") Integer appointmentId);
}
