package com.hms.service.module.patient;

import com.hms.entity.Stay;
import com.hms.entity.Undergoes;

import java.util.List;

public interface PatientModuleService {

    List<Stay> getCurrentlyAdmittedPatients();

    List<Undergoes> getRecentProcedures();
}
