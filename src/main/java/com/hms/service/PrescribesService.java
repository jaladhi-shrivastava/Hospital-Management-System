package com.hms.service;

import com.hms.entity.PrescribesId;

import java.util.List;

public interface PrescribesService {

    Prescribes addPrescription(Prescribes p);

    List<Prescribes> getAllPrescriptions();

    List<Prescribes> getByPatient(Integer patientId);

    List<Prescribes> getByPhysician(Integer physicianId);

    void deletePrescription(PrescribesId id);
}