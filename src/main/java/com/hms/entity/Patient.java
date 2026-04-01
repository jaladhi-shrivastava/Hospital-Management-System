package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PCP", referencedColumnName = "EmployeeID")
    private Physician pcp;
}