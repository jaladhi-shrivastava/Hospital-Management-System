package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "procedures")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedures {

    @Id
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "Cost")
    private Double cost;
}