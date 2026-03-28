package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medication")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medication {

    @Id
    @Column(name = "Code")
    private Integer code;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "Brand", length = 30)
    private String brand;

    @Column(name = "Description", length = 100)
    private String description;
}
