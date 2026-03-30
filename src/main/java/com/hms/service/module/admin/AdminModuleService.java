package com.hms.service.module.admin;

import com.hms.entity.Undergoes;

import java.util.List;
import java.util.Map;

public interface AdminModuleService {

    // GET /api/reports/revenue
    // Total revenue = sum of all procedure costs from Undergoes
    Double getTotalRevenue();

    // GET /procedures?patientId={id}
    // All procedures undergone by a specific patient with the assigned physician
    List<Undergoes> getProceduresByPatient(Integer patientSsn);

    // GET /api/departments/doctor-count
    // Number of doctors per department
    Map<String, Long> getDoctorCountPerDepartment();

    // GET /hospital/status
    // Aggregated snapshot: total patients, active admissions, occupied rooms
    Map<String, Object> getHospitalStatus();
}
