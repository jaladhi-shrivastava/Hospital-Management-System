package com.hms.dto.view.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// AppointmentViewController /appointments/dashboard
// model.addAttribute("nursesOnCall", appointmentModuleService.getNursesOnCall());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurseOnCallDTO {

    // From OnCallId (EmbeddedId)
    private Integer nurseId;
    private Integer blockFloor;
    private Integer blockCode;

    // From Nurse entity (@JsonIgnore LAZY in OnCall)
    private String nurseName;
    private String nursePosition;
    private Boolean registered;

    // From OnCall entity
    private LocalDateTime onCallStart;
    private LocalDateTime onCallEnd;
}