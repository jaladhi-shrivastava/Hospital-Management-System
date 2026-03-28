package com.hms.repository;

import com.hms.entity.Appointment;
import com.hms.entity.Patient;
import com.hms.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a.physician, COUNT(a) as count " +
            "FROM Appointment a " +
            "GROUP BY a.physician " +
            "ORDER BY count DESC")
    List<Object[]> findPhysicianAppointmentCounts();

    @Query("SELECT a.patient FROM Appointment a WHERE a.physician.employeeId = :physicianId")
    List<Patient> findPatientsByPhysicianId(Integer physicianId);
}