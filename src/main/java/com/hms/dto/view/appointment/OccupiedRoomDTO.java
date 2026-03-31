package com.hms.dto.view.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// AppointmentViewController /appointments/dashboard
// model.addAttribute("occupiedRooms", appointmentModuleService.getOccupiedRooms());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OccupiedRoomDTO {

    // From Room entity
    private Integer roomNumber;
    private String roomType;
    private Integer blockFloor;
    private Integer blockCode;

    // From Stay entity
    private Integer stayId;
    private LocalDateTime stayStart;
    private LocalDateTime stayEnd;

    // From Patient entity (via Stay — @JsonIgnore LAZY)
    private Integer patientSsn;
    private String patientName;
}