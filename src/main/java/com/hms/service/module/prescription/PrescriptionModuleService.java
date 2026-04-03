package com.hms.service.module.prescription;

import com.hms.dto.view.prescription.PrescriptionDTO;

import java.util.List;

public interface PrescriptionModuleService {

    List<PrescriptionDTO> getAllPrescriptions();

    List<PrescriptionDTO> getPrescriptionsByPatient(Integer patientSsn);

    List<PrescriptionDTO> getPrescriptionsByPhysician(Integer physicianId);

    List<PrescriptionDTO> getPrescriptionsByAppointment(Integer appointmentId);
}