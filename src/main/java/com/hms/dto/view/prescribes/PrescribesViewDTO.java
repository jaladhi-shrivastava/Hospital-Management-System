package com.hms.dto.view.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// PrescriptionViewController:
// /prescriptions/by-patient     → model.addAttribute("prescriptions", getPrescriptionsByPatient(patientId))
// /prescriptions/by-physician   → model.addAttribute("prescriptions", getPrescriptionsByPhysician(physicianId))
// /prescriptions/by-appointment → model.addAttribute("prescriptions", getPrescriptionsByAppointment(appointmentId))
// All three views share the same DTO shape

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescribesViewDTO {

    // From PrescribesId (EmbeddedId)
    private Integer physicianId;
    private Integer patientSsn;
    private Integer medicationCode;
    private LocalDateTime date;

    // From Physician entity (LAZY via insertable=false)
    private String physicianName;
    private String physicianPosition;

    // From Patient entity (LAZY via insertable=false)
    private String patientName;
    private String patientPhone;

    // From Medication entity (LAZY via insertable=false)
    private String medicationName;
    private String medicationBrand;
    private String medicationDescription;

    // From Appointment entity (nullable LAZY)
    private Integer appointmentId;
    private String examinationRoom;

    // From Prescribes entity
    private String dose;
}