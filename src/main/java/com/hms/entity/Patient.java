package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(name = "SSN")
    private Integer ssn;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "Address", length = 30)
    private String address;

    @Column(name = "Phone", length = 30)
    private String phone;

    @Column(name = "InsuranceID")
    private Integer insuranceId;

    // PCP = Primary Care Physician
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PCP", referencedColumnName = "EmployeeID")
    @JsonIgnore
    private Physician pcp;
}