package com.hms.service.module.patient;

import com.hms.dto.view.patient.AdmittedPatientDTO;
import com.hms.dto.view.patient.RecentProcedureDTO;

import java.util.List;

public interface PatientModuleService {

    // GET /api/patients/currently-admitted
    List<AdmittedPatientDTO> getCurrentlyAdmittedPatients();

    // GET /api/patients/recent-procedures
    List<RecentProcedureDTO> getRecentProcedures();
}