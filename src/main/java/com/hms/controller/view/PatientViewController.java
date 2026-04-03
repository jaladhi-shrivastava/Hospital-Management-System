package com.hms.controller.view;

import com.hms.dto.view.patient.AdmittedPatientDTO;
import com.hms.dto.view.patient.RecentProcedureDTO;
import com.hms.service.module.patient.PatientModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientViewController {

    @Autowired
    private PatientModuleService patientModuleService;

    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(defaultValue = "0") int admittedPage,
            @RequestParam(defaultValue = "0") int procedurePage,
            Model model) {

        int pageSize = 2; // you can change to 3 or 5

        // =========================
        // 1. Currently Admitted Patients Pagination
        // =========================
        List<AdmittedPatientDTO> allAdmittedPatients = patientModuleService.getAdmittedPatients();

        int admittedStart = admittedPage * pageSize;
        int admittedEnd = Math.min(admittedStart + pageSize, allAdmittedPatients.size());

        List<AdmittedPatientDTO> admittedPatientsPage =
                allAdmittedPatients.subList(admittedStart, admittedEnd);

        int admittedTotalPages = (int) Math.ceil((double) allAdmittedPatients.size() / pageSize);

        // =========================
        // 2. Recent Procedures Pagination
        // =========================
        List<RecentProcedureDTO> allRecentProcedures = patientModuleService.getRecentProcedures();

        int procedureStart = procedurePage * pageSize;
        int procedureEnd = Math.min(procedureStart + pageSize, allRecentProcedures.size());

        List<RecentProcedureDTO> recentProceduresPage =
                allRecentProcedures.subList(procedureStart, procedureEnd);

        int procedureTotalPages = (int) Math.ceil((double) allRecentProcedures.size() / pageSize);

        // =========================
        // Send to Thymeleaf
        // =========================
        model.addAttribute("admittedPatients", admittedPatientsPage);
        model.addAttribute("recentProcedures", recentProceduresPage);

        model.addAttribute("admittedCurrentPage", admittedPage);
        model.addAttribute("admittedTotalPages", admittedTotalPages);

        model.addAttribute("procedureCurrentPage", procedurePage);
        model.addAttribute("procedureTotalPages", procedureTotalPages);

        model.addAttribute("totalAdmittedCount", allAdmittedPatients.size());
        model.addAttribute("totalProcedureCount", allRecentProcedures.size());

        return "patient/dashboard";
    }
}