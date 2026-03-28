package com.hms.module.physician;

import com.hms.entity.Patient;
import com.hms.entity.Physician;
import com.hms.entity.TrainedIn;

import java.util.List;

public interface PhysicianModuleService {

    List<TrainedIn> getPhysiciansWithExpiringCertifications();

    Physician getMostBusyPhysician();

    List<Patient> getPatientsByPhysician(Integer physicianId);

    List<TrainedIn> getCertifiedDoctorsForProcedure(Integer procedureCode);
}
