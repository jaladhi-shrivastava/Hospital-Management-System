package com.hms.service.module.admin;

import com.hms.dto.view.admin.AdminDashboardDTO;
import com.hms.dto.view.admin.AdminProcedureDTO;

import java.util.List;
import java.util.Map;

public interface AdminModuleService {

    // GET /hospital/status
    AdminDashboardDTO getHospitalStatus();

    // GET /api/reports/revenue
    Double getTotalRevenue();

    // GET /procedures?patientId={id}
    List<AdminProcedureDTO> getProceduresByPatient(Integer patientSsn);

    // GET /api/departments/doctor-count
    Map<String, Long> getDoctorCountPerDepartment();
}