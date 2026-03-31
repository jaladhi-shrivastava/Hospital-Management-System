package com.hms.dto.view.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardDTO {

    private Double totalRevenue;
    private Map<String, Long> doctorCountPerDepartment;
    private Map<String, Object> hospitalStatus;
}
