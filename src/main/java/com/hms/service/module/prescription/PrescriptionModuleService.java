package com.hms.service.module.prescription;

import com.hms.entity.Prescribes;

import java.util.List;

public interface PrescriptionModuleService {

    List<Prescribes> getPrescriptionsByPatient(Integer patientSsn);

    List<Prescribes> getPrescriptionsByPhysician(Integer physicianId);

    List<Prescribes> getPrescriptionsByAppointment(Integer appointmentId);
}
