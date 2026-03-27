package com.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient", referencedColumnName = "SSN")
    @JsonIgnore
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Room", referencedColumnName = "RoomNumber")
    @JsonIgnore
    private Room room;

    @Column(name = "StayStart")
    private LocalDateTime stayStart;

    @Column(name = "StayEnd")
    private LocalDateTime stayEnd;
}