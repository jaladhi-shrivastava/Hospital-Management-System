package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "DepartmentID")
    private Integer departmentId;

    @Column(name = "Name", length = 30)
    private String name;

    // Head physician of this department
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Head", referencedColumnName = "EmployeeID")
    private Physician head;
}
