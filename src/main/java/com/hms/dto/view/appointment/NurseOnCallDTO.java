package com.hms.dto.view.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class NurseOnCallDTO {

    private Integer nurseId;
    private Integer blockFloor;
    private Integer blockCode;

    private String nurseName;
    private String nursePosition;
    private Boolean registered;

    private LocalDateTime onCallStart;
    private LocalDateTime onCallEnd;
}