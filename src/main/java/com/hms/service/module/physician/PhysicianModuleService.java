package com.hms.service.module.physician;

import com.hms.dto.view.physician.CertifiedDoctorDTO;
import com.hms.dto.view.physician.ExpiringCertificationDTO;
import com.hms.dto.view.physician.MostBusyPhysicianDTO;
import com.hms.dto.view.physician.PhysicianPatientDTO;

import java.util.List;

public interface PhysicianModuleService {

    // GET /api/physicians/most-busy
    MostBusyPhysicianDTO getMostBusyPhysician();

    // GET /api/physicians/certification-expiring
    List<ExpiringCertificationDTO> getPhysiciansCertifications();

    // GET /api/physicians/{id}/patients
    List<PhysicianPatientDTO> getPatientsByPhysician(Integer physicianId);

    // GET /api/procedures/{id}/certified-doctors
    List<CertifiedDoctorDTO> getCertifiedDoctorsForProcedure(Integer procedureCode);
}