package com.hms.dto.view.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminProcedureDTO {

    private Integer patientSsn;
    private Integer procedureCode;
    private Integer stayId;
    private LocalDateTime dateUndergoes;

    private String procedureName;
    private Double procedureCost;

    private Integer physicianId;
    private String physicianName;

    private Integer assistingNurseId;
    private String assistingNurseName;
}