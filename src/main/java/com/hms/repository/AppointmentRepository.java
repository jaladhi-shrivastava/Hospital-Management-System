package com.hms.repository;

import com.hms.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    // Used by PhysicianModule: all appointments for a specific physician
    @Query("SELECT a FROM Appointment a WHERE a.physician.employeeId = :physicianId")
    List<Appointment> findByPhysicianId(@Param("physicianId") Integer physicianId);

    // Used by PhysicianModule: all appointments grouped to find busiest physician
    // Returns Object[] { physician, count }
    @Query("SELECT a.physician, COUNT(a) as cnt FROM Appointment a GROUP BY a.physician ORDER BY cnt DESC")
    List<Object[]> findPhysicianAppointmentCounts();

    // Used by PhysicianModule: get all patients for a specific physician
    @Query("SELECT DISTINCT a.patient FROM Appointment a WHERE a.physician.employeeId = :physicianId")
    List<com.hms.entity.Patient> findPatientsByPhysicianId(@Param("physicianId") Integer physicianId);
}
