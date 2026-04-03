package com.hms.integration;

import static org.junit.jupiter.api.Assertions.*;

import com.hms.entity.*;
import com.hms.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HMSDatabaseIntegrationTest {

    @Autowired private PatientRepository patientRepository;
    @Autowired private PhysicianRepository physicianRepository;
    @Autowired private AppointmentRepository appointmentRepository;
    @Autowired private DepartmentRepository departmentRepository;
    @Autowired private RoomRepository roomRepository;
    @Autowired private BlockRepository blockRepository;
    @Autowired private StayRepository stayRepository;
    @Autowired private ProceduresRepository proceduresRepository;


    @Test
    void dbTest1_VerifyMostBusyPhysicianQuery() {
        List<Object[]> counts = appointmentRepository.findPhysicianAppointmentCounts();

        assertNotNull(counts);
        assertFalse(counts.isEmpty(), "Should find appointment counts from real DB data");

        Integer topPhysicianId = (Integer) counts.get(0)[0];
        assertTrue(physicianRepository.existsById(topPhysicianId));
    }

    /*@Test
    void dbTest2_VerifyPhysicianDetails() {
        Physician doc = physicianRepository.findById(3).orElseThrow();
        assertEquals("Christopher Turk", doc.getName());
        assertEquals("Surgical Attending Physician", doc.getPosition());
    }*/


    @Test
    void dbTest2_VerifyHospitalStatusCounts() {
        long patientCount = patientRepository.count();
        long deptCount = departmentRepository.count();
        assertTrue(patientCount >= 4);
        assertEquals(3, deptCount);
    }

    @Test
    void dbTest3_VerifyDepartmentHeadRelationship() {
        Department dept = departmentRepository.findById(1).orElseThrow();
        assertEquals("General Medicine", dept.getName());
        assertEquals("Percival Cox", dept.getHead().getName());
    }


    @Test
    void dbTest4_VerifyPatientPCPAndPhone() {
        Patient patient = patientRepository.findById(100000001).orElseThrow();
        assertEquals("John Smith", patient.getName());
        assertEquals("555-0256", patient.getPhone());
        assertEquals("John Dorian", patient.getPcp().getName());
    }

    @Test
    void dbTest5_VerifyActiveStaysQuery() {
        List<Stay> activeStays = stayRepository.findActiveStays();

        assertNotNull(activeStays);
        assertFalse(activeStays.isEmpty());
        assertNotNull(activeStays.get(0).getRoom().getRoomNumber());
    }


    @Test
    void dbTest6_VerifyOccupiedRoomsQuery() {
        List<Stay> occupied = stayRepository.findOccupiedRoomStays();

        assertNotNull(occupied);
        boolean room111Found = occupied.stream()
                .anyMatch(s -> s.getRoom().getRoomNumber() == 111);

        assertTrue(room111Found, "Room 111 should be occupied based on SQL data");
    }

    @Test
    void dbTest7_VerifyRoomInfrastructure() {
        Room room = roomRepository.findById(123).orElseThrow();
        assertEquals("Single", room.getRoomType());
        assertEquals(1, room.getBlock().getId().getBlockFloor());
        assertEquals(3, room.getBlock().getId().getBlockCode());
    }


    /*@Test
    void dbTest9_VerifyProcedureCosts() {
        Procedures proc = proceduresRepository.findById(4).orElseThrow();
        assertEquals(10000.0, proc.getCost());
    }*/

    @Test
    void dbTest8_UpdateRoomAvailabilityRollbackCheck() {
        Room room = roomRepository.findById(101).orElseThrow();
        boolean originalStatus = room.getUnavailable();

        room.setUnavailable(!originalStatus);
        roomRepository.save(room);

        Room updatedRoom = roomRepository.findById(101).get();
        assertEquals(!originalStatus, updatedRoom.getUnavailable());
    }
}