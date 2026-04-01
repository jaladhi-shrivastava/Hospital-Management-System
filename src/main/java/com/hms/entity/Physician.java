package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "physician")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Physician {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "Position", length = 30)
    private String position;

    @Column(name = "SSN")
    private Integer ssn;
}