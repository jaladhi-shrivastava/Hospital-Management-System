package com.hms.repository;

import com.hms.entity.Appointment;
import com.hms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    @Query("SELECT a FROM Appointment a " +
            "LEFT JOIN FETCH a.patient " +
            "LEFT JOIN FETCH a.prepNurse " +
            "LEFT JOIN FETCH a.physician " +
            "WHERE a.physician.employeeId = :physicianId")
    List<Appointment> findByPhysicianId(@Param("physicianId") Integer physicianId);

    @Query("SELECT a.physician, COUNT(a) as cnt FROM Appointment a " +
            "GROUP BY a.physician.employeeId, a.physician.name, a.physician.position, a.physician.ssn " +
            "ORDER BY cnt DESC")
    List<Object[]> findPhysicianAppointmentCounts();


    @Query("SELECT DISTINCT a.patient FROM Appointment a " +
            "WHERE a.physician.employeeId = :physicianId")
    List<Patient> findPatientsByPhysicianId(@Param("physicianId") Integer physicianId);
}