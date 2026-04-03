package com.hms.dto.view.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {

    private Integer physicianId;
    private String physicianName;
    private String physicianPosition;

    private Integer patientSsn;
    private String patientName;

    private Integer medicationCode;
    private String medicationName;
    private String medicationBrand;

    private LocalDateTime prescriptionDate;
    private String dose;

    private Integer appointmentId;
}