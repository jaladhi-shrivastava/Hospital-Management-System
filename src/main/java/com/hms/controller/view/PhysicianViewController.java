package com.hms.controller.view;

import com.hms.service.module.physician.PhysicianModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/physicians")
public class PhysicianViewController {

    @Autowired
    private PhysicianModuleService physicianModuleService;


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("mostBusy",
                physicianModuleService.getMostBusyPhysician());
        model.addAttribute("expiringCerts",
                physicianModuleService.getPhysiciansCertifications());
        return "physician/dashboard";
    }

}