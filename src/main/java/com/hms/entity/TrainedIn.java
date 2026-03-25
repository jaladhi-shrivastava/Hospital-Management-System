package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class TrainedInId implements Serializable {
    @Column(name = "Physician")   private Integer physician;
    @Column(name = "Treatment")   private Integer treatment;
}

@Entity
@Table(name = "trained_in")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainedIn {

    @EmbeddedId
    private TrainedInId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", insertable = false, updatable = false)
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Treatment", insertable = false, updatable = false)
    private Procedures treatment;

    @Column(name = "CertificationDate")
    private LocalDateTime certificationDate;

    @Column(name = "CertificationExpires")
    private LocalDateTime certificationExpires;
}
