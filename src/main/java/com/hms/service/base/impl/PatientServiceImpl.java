package com.hms.service.base.impl;

import com.hms.entity.Patient;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repository.PatientRepository;
import com.hms.service.base.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer ssn) {
        return patientRepository.findById(ssn)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with SSN: " + ssn));
    }

    @Override
    public Patient updatePatient(Integer ssn, Patient patient) {
        Patient existingPatient = patientRepository.findById(ssn)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with SSN: " + ssn));

        existingPatient.setName(patient.getName());
        existingPatient.setAddress(patient.getAddress());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setInsuranceId(patient.getInsuranceId());
        existingPatient.setPcp(patient.getPcp());

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Integer ssn) {
        Patient existingPatient = patientRepository.findById(ssn)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with SSN: " + ssn));

        patientRepository.delete(existingPatient);
    }
}