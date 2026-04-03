package com.hms.dto.view.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmittedPatientDTO {

    private Integer patientSsn;
    private String patientName;
    private String patientPhone;
    private String patientAddress;
    private Integer pcpId;
    private String pcpName;

    private Integer stayId;
    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;

    // From Room entity (via Stay — @JsonIgnore LAZY)
    private Integer roomNumber;
    private String roomType;
}