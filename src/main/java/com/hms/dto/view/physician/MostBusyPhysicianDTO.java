package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class MostBusyPhysicianDTO {

    private Integer employeeId;
    private String name;
    private String position;

    private Long appointmentCount;
}