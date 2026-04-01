package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nurse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nurse {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "Position", length = 30)
    private String position;

    @Column(name = "Registered")
    private Boolean registered;

    @Column(name = "SSN")
    private Integer ssn;
}