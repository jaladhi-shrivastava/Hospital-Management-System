package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// PhysicianViewController /physicians/procedures/{id}/certified-doctors
// model.addAttribute("certifiedDoctors", physicianModuleService.getCertifiedDoctorsForProcedure(id));

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertifiedDoctorDTO {

    // From TrainedInId (EmbeddedId)
    private Integer physicianId;
    private Integer treatmentCode;

    // From Physician entity (@JsonIgnore LAZY in TrainedIn)
    private String physicianName;
    private String physicianPosition;

    // From Procedures entity (treatment)
    private String treatmentName;

    // From TrainedIn entity
    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}