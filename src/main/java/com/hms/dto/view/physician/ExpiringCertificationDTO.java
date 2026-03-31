package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// PhysicianViewController /physicians/dashboard
// model.addAttribute("expiringCerts", physicianModuleService.getPhysiciansCertifications());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpiringCertificationDTO {

    // From TrainedInId (EmbeddedId)
    private Integer physicianId;
    private Integer treatmentCode;

    // From Physician entity (@JsonIgnore LAZY in TrainedIn)
    private String physicianName;
    private String physicianPosition;

    // From Procedures entity (treatment — @JsonIgnore LAZY in TrainedIn)
    private String treatmentName;
    private Double treatmentCost;

    // From TrainedIn entity
    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}