package com.hms.controller.view;

import com.hms.dto.view.appointment.NurseOnCallDTO;
import com.hms.dto.view.appointment.OccupiedRoomDTO;
import com.hms.service.module.appointment.AppointmentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentViewController {

    @Autowired
    private AppointmentModuleService appointmentModuleService;

    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(defaultValue = "0") int roomPage,
            @RequestParam(defaultValue = "0") int nursePage,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        List<OccupiedRoomDTO> allRooms = appointmentModuleService.getOccupiedRooms();
        List<NurseOnCallDTO> allNurses = appointmentModuleService.getNursesOnCall();

        int roomStart = roomPage * size;
        int roomEnd = Math.min(roomStart + size, allRooms.size());
        List<OccupiedRoomDTO> paginatedRooms =
                (roomStart >= allRooms.size()) ? Collections.emptyList() : allRooms.subList(roomStart, roomEnd);

        int nurseStart = nursePage * size;
        int nurseEnd = Math.min(nurseStart + size, allNurses.size());
        List<NurseOnCallDTO> paginatedNurses =
                (nurseStart >= allNurses.size()) ? Collections.emptyList() : allNurses.subList(nurseStart, nurseEnd);

        int roomTotalPages = (int) Math.ceil((double) allRooms.size() / size);
        int nurseTotalPages = (int) Math.ceil((double) allNurses.size() / size);

        model.addAttribute("occupiedRooms", paginatedRooms);
        model.addAttribute("nursesOnCall", paginatedNurses);

        model.addAttribute("roomCurrentPage", roomPage);
        model.addAttribute("roomTotalPages", roomTotalPages);

        model.addAttribute("nurseCurrentPage", nursePage);
        model.addAttribute("nurseTotalPages", nurseTotalPages);

        model.addAttribute("size", size);

        model.addAttribute("totalOccupiedRooms", allRooms.size());
        model.addAttribute("totalNursesOnCall", allNurses.size());

        return "appointment/dashboard";
    }
}