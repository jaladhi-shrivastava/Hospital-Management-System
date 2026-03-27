package com.hms.service;

import com.hms.entity.Medication;
import java.util.List;

public interface MedicationService {

    Medication addMedication(Medication medication);

    List<Medication> getAllMedications();

    Medication getMedicationById(Integer code);

    void deleteMedication(Integer code);
}
