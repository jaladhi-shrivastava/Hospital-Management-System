package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertifiedDoctorDTO {


    private Integer physicianId;
    private Integer treatmentCode;


    private String physicianName;
    private String physicianPosition;


    private String treatmentName;


    private LocalDateTime certificationDate;
    private LocalDateTime certificationExpires;
}