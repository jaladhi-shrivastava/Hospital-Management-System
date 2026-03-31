package com.hms.dto.view.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

// AdminViewController /admin/dashboard
// model.addAttribute("totalRevenue",       adminModuleService.getTotalRevenue());
// model.addAttribute("doctorCountPerDept", adminModuleService.getDoctorCountPerDepartment());
// model.addAttribute("hospitalStatus",     adminModuleService.getHospitalStatus());

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardDTO {

    private Double totalRevenue;
    private Map<String, Long> doctorCountPerDepartment;
    private Map<String, Object> hospitalStatus;
}
