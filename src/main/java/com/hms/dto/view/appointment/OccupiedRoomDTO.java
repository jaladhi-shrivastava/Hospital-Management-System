package com.hms.dto.view.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OccupiedRoomDTO {

    private Integer roomNumber;
    private String roomType;
    private Integer blockFloor;
    private Integer blockCode;

    private Integer stayId;
    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;

    // From Patient entity (via Stay — @JsonIgnore LAZY)
    private Integer patientSsn;
    private String patientName;
}