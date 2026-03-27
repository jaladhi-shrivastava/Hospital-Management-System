package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "undergoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Undergoes {

    @EmbeddedId
    private UndergoesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Procedures", insertable = false, updatable = false)
    private Procedures procedures;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Stay", insertable = false, updatable = false)
    private Stay stay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", referencedColumnName = "EmployeeID")
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AssistingNurse", referencedColumnName = "EmployeeID")
    private Nurse assistingNurse;
}