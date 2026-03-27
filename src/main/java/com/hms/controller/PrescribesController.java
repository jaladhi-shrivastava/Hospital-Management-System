package com.hms.controller;

import com.hms.entity.Prescribes;
import com.hms.entity.PrescribesId;
import com.hms.service.PrescribesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescribesController {

    @Autowired
    private PrescribesService service;

    @PostMapping
    public Prescribes add(@RequestBody Prescribes p) {
        return service.addPrescription(p);
    }

    @GetMapping
    public List<Prescribes> getAll() {
        return service.getAllPrescriptions();
    }

    @GetMapping("/patient/{id}")
    public List<Prescribes> getByPatient(@PathVariable Integer id) {
        return service.getByPatient(id);
    }

    @GetMapping("/physician/{id}")
    public List<Prescribes> getByPhysician(@PathVariable Integer id) {
        return service.getByPhysician(id);
    }

    @DeleteMapping
    public String delete(
            @RequestParam Integer physician,
            @RequestParam Integer patient,
            @RequestParam Integer medication,
            @RequestParam String date
    ) {
        PrescribesId id = new PrescribesId(
                physician,
                patient,
                medication,
                LocalDateTime.parse(date)
        );

        service.deletePrescription(id);
        return "Deleted successfully";
    }
}