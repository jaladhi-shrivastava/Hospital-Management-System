package com.hms.dto.view.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// PatientViewController /patients/dashboard
// model.addAttribute("recentProcedures", patientModuleService.getRecentProcedures());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentProcedureDTO {

    // From UndergoesId (EmbeddedId)
    private Integer patientSsn;
    private Integer procedureCode;
    private Integer stayId;
    private LocalDateTime dateUndergoes;

    // From Patient entity (LAZY via insertable=false)
    private String patientName;

    // From Procedures entity (LAZY via insertable=false)
    private String procedureName;
    private Double procedureCost;

    // From Physician entity
    private Integer physicianId;
    private String physicianName;

    // From Nurse entity (nullable — AssistingNurse)
    private Integer assistingNurseId;
    private String assistingNurseName;
}