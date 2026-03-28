package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "prescribes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prescribes {

    @EmbeddedId
    private PrescribesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", insertable = false, updatable = false)
    @JsonIgnore
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", insertable = false, updatable = false)
    @JsonIgnore
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Medication", insertable = false, updatable = false)
    @JsonIgnore
    private Medication medication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Appointment", referencedColumnName = "AppointmentID")
    @JsonIgnore
    private Appointment appointment;

    @Column(name = "Dose", length = 30)
    private String dose;
}