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
    @Column(name = "appointment_id")
    private Integer appointmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prep_nurse_id")
    private Nurse prepNurse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @Column(name = "start_time")
    private LocalDateTime start;

    @Column(name = "end_time")
    private LocalDateTime end;

    @Column(name = "examination_room")
    private String examinationRoom;
}