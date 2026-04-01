package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @Column(name = "AppointmentID")
    private Integer appointmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", referencedColumnName = "SSN")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PrepNurse", referencedColumnName = "EmployeeID")
    private Nurse prepNurse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", referencedColumnName = "EmployeeID")
    private Physician physician;

    @Column(name = "Starto")
    private LocalDateTime start;

    @Column(name = "Endo")
    private LocalDateTime end;

    @Column(name = "ExaminationRoom")
    private String examinationRoom;
}