package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Entity
@Table(name = "stay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stay {

    @Id
    @Column(name = "StayID")
    private Integer stayId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", referencedColumnName = "SSN")
    private Patient patient;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Room", referencedColumnName = "RoomNumber")
    private Room room;

    @Column(name = "StayStart")
    private LocalDateTime stayStart;

    @Column(name = "StayEnd")
    private LocalDateTime stayEnd;
}