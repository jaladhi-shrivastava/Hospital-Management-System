package com.hms.module.admin;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.Department;
import com.hms.entity.Procedures;
import com.hms.entity.Undergoes;

import java.util.List;
import java.util.Map;

public interface AdminModuleService {

    Double getTotalRevenue();

    List<Undergoes> getProceduresByPatient(Integer patientSsn);

    Map<String, Long> getDoctorCountPerDepartment();
}