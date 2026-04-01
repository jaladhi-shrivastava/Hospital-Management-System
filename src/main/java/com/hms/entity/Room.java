package com.hms.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @Column(name = "RoomNumber")
    private Integer roomNumber;

    @Column(name = "RoomType", length = 30)
    private String roomType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor"),
            @JoinColumn(name = "BlockCode",  referencedColumnName = "BlockCode")
    })
    private Block block;

    @Column(name = "Unavailable")
    private Boolean unavailable;
}