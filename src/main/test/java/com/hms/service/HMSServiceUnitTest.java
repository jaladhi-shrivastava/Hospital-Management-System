package com.hms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.hms.entity.*;
import com.hms.repository.*;
import com.hms.service.module.admin.AdminModuleServiceImpl;
import com.hms.service.module.appointment.AppointmentModuleServiceImpl;
import com.hms.service.module.patient.PatientModuleServiceImpl;
import com.hms.service.module.physician.PhysicianModuleServiceImpl;
import com.hms.service.module.PrescriptionModuleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class HMSServiceUnitTest {

//    making the object for all the 4 mock repos so that it can be used during the exceution
    @Mock private PhysicianRepository physicianRepository;
    @Mock private AppointmentRepository appointmentRepository;
    @Mock private StayRepository stayRepository;
    @Mock private UndergoesRepository undergoesRepository;
    @Mock private PatientRepository patientRepository;
    @Mock private DepartmentRepository departmentRepository;
    @Mock private OnCallRepository onCallRepository;
    @Mock private PrescribesRepository prescribesRepository;
    @Mock private TrainedInRepository trainedInRepository;

//    using the mock to add these in the service
    @InjectMocks private AdminModuleServiceImpl adminService;
    @InjectMocks private PhysicianModuleServiceImpl physicianService;
    @InjectMocks private PatientModuleServiceImpl patientService;
    @InjectMocks private AppointmentModuleServiceImpl appointmentService;
    @InjectMocks private PrescriptionModuleServiceImpl prescriptionService;


    @Test
    void test1_GetMostBusyPhysician() {

        Physician doc = new Physician(101, "Dr. Jaladhi", "Surgeon", 111);

        Object[] row = new Object[]{doc, 5L};
        List<Object[]> mockResult = new ArrayList<>();
        mockResult.add(row);

        when(appointmentRepository.findPhysicianAppointmentCounts()).thenReturn(mockResult);
        Physician result = physicianService.getMostBusyPhysician();


        assertNotNull(result);
        assertEquals("Dr. Jaladhi", result.getName());
    }

    @Test
    void test2_GetCertifiedDoctorsForProcedure() {
        TrainedIn ti = new TrainedIn();
        when(trainedInRepository.findById_Treatment(7)).thenReturn(List.of(ti));

        List<TrainedIn> result = physicianService.getCertifiedDoctorsForProcedure(7);
        assertEquals(1, result.size());
    }

    @Test
    void test3_GetTotalRevenue() {
        Procedures p = new Procedures(); p.setCost(1200.0);
        Undergoes u = new Undergoes(); u.setProcedures(p);
        when(undergoesRepository.findAllWithDetails()).thenReturn(List.of(u));

        Double revenue = adminService.getTotalRevenue();
        assertEquals(1200.0, revenue);
    }

    @Test
    void test4_GetHospitalStatus() {
        when(patientRepository.count()).thenReturn(10L);
        when(stayRepository.findActiveStays()).thenReturn(Collections.emptyList());
        when(stayRepository.findOccupiedRoomStays()).thenReturn(Collections.emptyList());
        when(departmentRepository.count()).thenReturn(4L);

        Map<String, Object> status = adminService.getHospitalStatus();
        assertEquals(10L, status.get("totalPatients"));
        assertEquals(4L, status.get("totalDepartments"));
    }

    @Test
    void test5_GetCurrentlyAdmittedPatients() {
        Stay activeStay = new Stay(); activeStay.setStayEnd(null);
        when(stayRepository.findActiveStays()).thenReturn(List.of(activeStay));

        List<Stay> result = patientService.getCurrentlyAdmittedPatients();
        assertNull(result.get(0).getStayEnd());
    }

    @Test
    void test6_GetOccupiedRooms() {
        Stay s = new Stay();
        when(stayRepository.findOccupiedRoomStays()).thenReturn(List.of(s));

        List<Stay> result = appointmentService.getOccupiedRooms();
        assertEquals(1, result.size());
    }

    @Test
    void test7_GetNursesOnCall() {
        OnCall oc = new OnCall();
        when(onCallRepository.findCurrentlyOnCall(any(LocalDateTime.class))).thenReturn(List.of(oc));

        List<OnCall> result = appointmentService.getNursesOnCall();
        assertEquals(1, result.size());
    }

    @Test
    void test8_GetPrescriptionsByPhysician() {
        Prescribes pr = new Prescribes();
        when(prescribesRepository.findByPhysicianId(101)).thenReturn(List.of(pr));

        List<Prescribes> result = prescriptionService.getPrescriptionsByPhysician(101);
        assertEquals(1, result.size());
    }
}