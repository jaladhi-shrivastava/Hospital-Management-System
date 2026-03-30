package com.hms.service;

import com.hms.entity.Prescribes;
import com.hms.entity.PrescribesId;

import java.util.List;

public interface PrescribesService {

    Prescribes savePrescribes(Prescribes prescribes);

    List<Prescribes> getAllPrescribes();

    Prescribes getPrescribesById(PrescribesId id);

    void deletePrescribes(PrescribesId id);

    // ✅ MUST match repository method names
    List<Prescribes> getPrescribesByPatient(Integer patientSsn);

    List<Prescribes> getPrescribesByPhysician(Integer physicianId);

    List<Prescribes> getPrescribesByAppointment(Integer appointmentId);
}