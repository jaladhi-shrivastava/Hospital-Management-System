package com.hms.dto.view.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// PatientViewController /patients/dashboard
// model.addAttribute("admittedPatients", patientModuleService.getCurrentlyAdmittedPatients());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmittedPatientDTO {

    // From Patient entity
    private Integer patientSsn;
    private String patientName;
    private String patientPhone;
    private String patientAddress;

    // From Physician entity (via Patient.pcp — @JsonIgnore LAZY)
    private Integer pcpId;
    private String pcpName;

    // From Stay entity
    private Integer stayId;
    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;

    // From Room entity (via Stay — @JsonIgnore LAZY)
    private Integer roomNumber;
    private String roomType;
}