package com.hms.dto.view.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// AdminViewController /admin/procedures
// model.addAttribute("procedures", adminModuleService.getProceduresByPatient(patientId));

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminProcedureDTO {

    // From UndergoesId (EmbeddedId)
    private Integer patientSsn;
    private Integer procedureCode;
    private Integer stayId;
    private LocalDateTime dateUndergoes;

    // From Procedures entity
    private String procedureName;
    private Double procedureCost;

    // From Physician entity
    private Integer physicianId;
    private String physicianName;

    // From Nurse entity (nullable)
    private Integer assistingNurseId;
    private String assistingNurseName;
}