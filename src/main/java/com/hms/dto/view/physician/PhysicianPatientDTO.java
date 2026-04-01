package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicianPatientDTO {


    private Integer patientSsn;
    private String patientName;
    private String patientPhone;
    private String patientAddress;
    private Integer insuranceId;


    private Integer pcpId;
    private String pcpName;
}