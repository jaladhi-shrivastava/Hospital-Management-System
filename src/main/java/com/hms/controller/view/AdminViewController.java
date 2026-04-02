package com.hms.controller.view;

import com.hms.dto.view.admin.AdminProcedureDTO;
import com.hms.service.module.admin.AdminModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    private AdminModuleService adminModuleService;

    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalRevenue", adminModuleService.getTotalRevenue());
        model.addAttribute("doctorCountPerDept", adminModuleService.getDoctorCountPerDepartment());
        model.addAttribute("hospitalStatus", adminModuleService.getHospitalStatus());
        return "admin/dashboard";
    }

    @GetMapping("/procedures")
    public String proceduresByPatient(
            @RequestParam(required = false) Integer patientId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        List<AdminProcedureDTO> allProcedures = Collections.emptyList();

        if (patientId != null) {
            allProcedures = adminModuleService.getProceduresByPatient(patientId);
        }

        int start = page * size;
        int end = Math.min(start + size, allProcedures.size());

        List<AdminProcedureDTO> paginatedProcedures =
                (start >= allProcedures.size()) ? Collections.emptyList() : allProcedures.subList(start, end);

        int totalPages = (int) Math.ceil((double) allProcedures.size() / size);

        model.addAttribute("procedures", paginatedProcedures);
        model.addAttribute("patientId", patientId);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);

        return "admin/procedures";
    }
}