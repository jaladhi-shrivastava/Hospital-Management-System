package com.hms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UndergoesId implements Serializable {

    @Column(name = "Patient")
    private Integer patient;

    @Column(name = "Procedures")
    private Integer procedures;

    @Column(name = "Stay")
    private Integer stay;

    @Column(name = "DateUndergoes")
    private LocalDateTime dateUndergoes;
}