package com.hms.controller.base;

import com.hms.entity.Physician;
import com.hms.service.base.PhysicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/physicians")
@CrossOrigin("*")
public class PhysicianController {

    @Autowired
    private PhysicianService physicianService;

    @PostMapping
    public Physician createPhysician(@RequestBody Physician physician) {
        return physicianService.savePhysician(physician);
    }

    @GetMapping
    public List<Physician> getAllPhysicians() {
        return physicianService.getAllPhysicians();
    }

    @GetMapping("/{id}")
    public Physician getPhysicianById(@PathVariable Integer id) {
        return physicianService.getPhysicianById(id);
    }

    @PutMapping("/{id}")
    public Physician updatePhysician(@PathVariable Integer id, @RequestBody Physician physician) {
        return physicianService.updatePhysician(id, physician);
    }

    @DeleteMapping("/{id}")
    public String deletePhysician(@PathVariable Integer id) {
        physicianService.deletePhysician(id);
        return "Physician deleted successfully";
    }
}