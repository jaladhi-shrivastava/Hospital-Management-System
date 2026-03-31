package com.hms.dto.view.physician;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// PhysicianViewController /physicians/dashboard
// model.addAttribute("mostBusy", physicianModuleService.getMostBusyPhysician());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MostBusyPhysicianDTO {

    // From Physician entity
    private Integer employeeId;
    private String name;
    private String position;

    // Computed — highest appointment count
    private Long appointmentCount;
}