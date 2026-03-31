package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// PhysicianViewController /physicians/{id}/patients
// model.addAttribute("patients", physicianModuleService.getPatientsByPhysician(id));

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicianPatientDTO {

    // From Patient entity
    private Integer patientSsn;
    private String patientName;
    private String patientPhone;
    private String patientAddress;
    private Integer insuranceId;

    // From Physician entity (via Patient.pcp — @JsonIgnore LAZY)
    private Integer pcpId;
    private String pcpName;
}