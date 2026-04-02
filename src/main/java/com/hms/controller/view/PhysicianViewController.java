package com.hms.controller.view;

import com.hms.dto.view.physician.ExpiringCertificationDTO;
import com.hms.service.module.physician.PhysicianModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/physicians")
public class PhysicianViewController {

    @Autowired
    private PhysicianModuleService physicianModuleService;

    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(defaultValue = "0") int certPage,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        List<ExpiringCertificationDTO> allCerts = physicianModuleService.getPhysiciansCertifications();

        int start = certPage * size;
        int end = Math.min(start + size, allCerts.size());

        List<ExpiringCertificationDTO> paginatedCerts =
                (start >= allCerts.size()) ? Collections.emptyList() : allCerts.subList(start, end);

        int totalPages = (int) Math.ceil((double) allCerts.size() / size);

        model.addAttribute("mostBusy", physicianModuleService.getMostBusyPhysician());
        model.addAttribute("expiringCerts", paginatedCerts);
        model.addAttribute("certCurrentPage", certPage);
        model.addAttribute("certTotalPages", totalPages);
        model.addAttribute("size", size);

        return "physician/dashboard";
    }
}