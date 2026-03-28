package com.hms.module.prescription;

import com.hms.entity.Prescribes;

import java.util.List;

public interface PrescriptionModuleService {

    // All prescriptions for a specific patient (by SSN)
    List<Prescribes> getPrescriptionsByPatient(Integer patientSsn);

    // All prescriptions written by a specific physician
    List<Prescribes> getPrescriptionsByPhysician(Integer physicianId);

    // All prescriptions linked to a specific appointment
    List<Prescribes> getPrescriptionsByAppointment(Integer appointmentId);
}
