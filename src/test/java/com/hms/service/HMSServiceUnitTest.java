package com.hms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hms.dto.view.admin.AdminDashboardDTO;
import com.hms.dto.view.appointment.OccupiedRoomDTO;
import com.hms.dto.view.patient.AdmittedPatientDTO;
import com.hms.dto.view.physician.MostBusyPhysicianDTO;
import com.hms.entity.*;
import com.hms.repository.*;
import com.hms.service.module.admin.AdminModuleServiceImpl;
import com.hms.service.module.appointment.AppointmentModuleServiceImpl;
import com.hms.service.module.patient.PatientModuleServiceImpl;
import com.hms.service.module.physician.PhysicianModuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class HMSServiceUnitTest {

    @Mock private PhysicianRepository physicianRepository;
    @Mock private AppointmentRepository appointmentRepository;
    @Mock private StayRepository stayRepository;
    @Mock private PatientRepository patientRepository;
    @Mock private DepartmentRepository departmentRepository;
    @Mock private UndergoesRepository undergoesRepository;
    @Mock private AffiliatedWithRepository affiliatedWithRepository;

    @InjectMocks private PhysicianModuleServiceImpl physicianService;
    @InjectMocks private AdminModuleServiceImpl adminService;
    @InjectMocks private PatientModuleServiceImpl patientService;
    @InjectMocks private AppointmentModuleServiceImpl appointmentService;

    @Test
    void test1_GetMostBusyPhysician_Success() {
        List<Object[]> mockResult = new ArrayList<>();
        mockResult.add(new Object[]{1, 10L});

        Physician doc = new Physician(1, "John Dorian", "Internist", 111);

        when(appointmentRepository.findPhysicianAppointmentCounts()).thenReturn(mockResult);
        when(physicianRepository.findById(1)).thenReturn(Optional.of(doc));

        MostBusyPhysicianDTO result = physicianService.getMostBusyPhysician();

        assertNotNull(result);
        assertEquals("John Dorian", result.getName());
        assertEquals(10L, result.getAppointmentCount());
    }

    @Test
    void test2_GetHospitalStatus_Success() {
        when(patientRepository.count()).thenReturn(100L);
        when(departmentRepository.count()).thenReturn(5L);
        when(stayRepository.findActiveStays()).thenReturn(Collections.emptyList());
        when(stayRepository.findOccupiedRoomStays()).thenReturn(Collections.emptyList());
        when(undergoesRepository.findAllWithDetails()).thenReturn(Collections.emptyList());
        when(affiliatedWithRepository.findAll()).thenReturn(Collections.emptyList());
        when(departmentRepository.findAll()).thenReturn(Collections.emptyList());

        AdminDashboardDTO result = adminService.getHospitalStatus();

        assertEquals(100L, result.getHospitalStatus().get("totalPatients"));
        assertEquals(5L, result.getHospitalStatus().get("totalDepartments"));
    }

    @Test
    void test3_GetCurrentlyAdmittedPatients_Success() {
        Patient p = new Patient(101, "John Smith", "Addr", "123", 1, null);
        Stay activeStay = new Stay(301, p, null, LocalDateTime.now(), null);

        when(stayRepository.findActiveStays()).thenReturn(List.of(activeStay));

        List<AdmittedPatientDTO> result = patientService.getAdmittedPatients();

        assertFalse(result.isEmpty());
        assertEquals("John Smith", result.get(0).getPatientName());
    }

    @Test
    void test4_GetOccupiedRooms_Success() {
        Room r = new Room(101, "Single", null, true);
        Stay s = new Stay(501, null, r, LocalDateTime.now(), null);

        when(stayRepository.findOccupiedRoomStays()).thenReturn(List.of(s));

        List<OccupiedRoomDTO> result = appointmentService.getOccupiedRooms();

        assertEquals(101, result.get(0).getRoomNumber());
        assertEquals("Single", result.get(0).getRoomType());
    }

    @Test
    void test5_GetMostBusyPhysician_EmptyResult() {
        when(appointmentRepository.findPhysicianAppointmentCounts()).thenReturn(Collections.emptyList());

        MostBusyPhysicianDTO result = physicianService.getMostBusyPhysician();

        assertNull(result);
    }

    @Test
    void test6_GetMostBusyPhysician_PhysicianNotFound() {
        List<Object[]> mockResult = new ArrayList<>();
        mockResult.add(new Object[]{99, 5L});

        when(appointmentRepository.findPhysicianAppointmentCounts()).thenReturn(mockResult);
        when(physicianRepository.findById(99)).thenReturn(Optional.empty());

        MostBusyPhysicianDTO result = physicianService.getMostBusyPhysician();
        assertNull(result);
    }

    @Test
    void test7_GetAdmittedPatients_ReturnsEmptyList() {
        when(stayRepository.findActiveStays()).thenReturn(Collections.emptyList());

        List<AdmittedPatientDTO> result = patientService.getAdmittedPatients();

        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }

    @Test
    void test8_GetOccupiedRooms_NullSafetyCheck() {
        Stay corruptedStay = new Stay();
        corruptedStay.setRoom(null);

        when(stayRepository.findOccupiedRoomStays()).thenReturn(List.of(corruptedStay));

        List<OccupiedRoomDTO> result = appointmentService.getOccupiedRooms();

        assertNull(result.get(0).getRoomNumber());
        assertNotNull(result);
    }
}