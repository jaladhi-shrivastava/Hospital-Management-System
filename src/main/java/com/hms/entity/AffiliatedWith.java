package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class AffiliatedWithId implements Serializable {
    @Column(name = "Physician")   private Integer physician;
    @Column(name = "Department")  private Integer department;
}

@Entity
@Table(name = "affiliated_with")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffiliatedWith {

    @EmbeddedId
    private AffiliatedWithId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Physician", insertable = false, updatable = false)
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Department", insertable = false, updatable = false)
    private Department department;

    @Column(name = "PrimaryAffiliation")
    private Boolean primaryAffiliation;
}
