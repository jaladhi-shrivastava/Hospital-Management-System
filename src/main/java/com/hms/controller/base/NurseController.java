package com.hms.controller.base;

import com.hms.entity.Nurse;
import com.hms.service.base.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nurses")
@CrossOrigin("*")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PostMapping
    public Nurse createNurse(@RequestBody Nurse nurse) {
        return nurseService.saveNurse(nurse);
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @GetMapping("/{id}")
    public Nurse getNurseById(@PathVariable Integer id) {
        return nurseService.getNurseById(id);
    }

    @PutMapping("/{id}")
    public Nurse updateNurse(@PathVariable Integer id, @RequestBody Nurse nurse) {
        return nurseService.updateNurse(id, nurse);
    }

    @DeleteMapping("/{id}")
    public String deleteNurse(@PathVariable Integer id) {
        nurseService.deleteNurse(id);
        return "Nurse deleted successfully";
    }
}