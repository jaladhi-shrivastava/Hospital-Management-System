package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PrescribesId implements Serializable {

    @Column(name = "Physician")
    private Integer physician;

    @Column(name = "Patient")
    private Integer patient;

    @Column(name = "Medication")
    private Integer medication;

    @Column(name = "Date")
    private LocalDateTime date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrescribesId)) return false;
        PrescribesId that = (PrescribesId) o;
        return Objects.equals(physician, that.physician) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(medication, that.medication) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physician, patient, medication, date);
    }
}