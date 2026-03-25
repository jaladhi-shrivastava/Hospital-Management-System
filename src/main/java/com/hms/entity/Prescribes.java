package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class PrescribesId implements Serializable {
    @Column(name = "Physician")    private Integer physician;
    @Column(name = "Patient")      private Integer patient;
    @Column(name = "Medication")   private Integer medication;
    @Column(name = "Date")         private LocalDateTime date;
}

@Entity
@Table(name = "prescribes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescribes {

    @EmbeddedId
    private PrescribesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", insertable = false, updatable = false)
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Medication", insertable = false, updatable = false)
    private Medication medication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Appointment", referencedColumnName = "AppointmentID")
    private Appointment appointment;

    @Column(name = "Dose", length = 30)
    private String dose;
}
