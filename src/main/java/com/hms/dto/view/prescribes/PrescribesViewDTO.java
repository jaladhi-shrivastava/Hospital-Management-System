package com.hms.dto.view.prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescribesViewDTO {

    // From PrescribesId (EmbeddedId)
    private Integer physicianId;
    private Integer patientSsn;
    private Integer medicationCode;
    private LocalDateTime date;

    private String physicianName;
    private String physicianPosition;

    private String patientName;
    private String patientPhone;

    private String medicationName;
    private String medicationBrand;
    private String medicationDescription;

    // From Appointment entity (nullable LAZY)
    private Integer appointmentId;
    private String examinationRoom;

    // From Prescribes entity
    private String dose;
}