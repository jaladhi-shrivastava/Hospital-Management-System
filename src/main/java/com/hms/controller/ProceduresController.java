package com.hms.controller;

import com.hms.entity.Procedures;
import com.hms.service.ProceduresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedures")
@CrossOrigin("*")
public class ProceduresController {

    @Autowired
    private ProceduresService proceduresService;

    @PostMapping
    public Procedures createProcedure(@RequestBody Procedures procedures) {
        return proceduresService.saveProcedure(procedures);
    }

    @GetMapping
    public List<Procedures> getAllProcedures() {
        return proceduresService.getAllProcedures();
    }

    @GetMapping("/{id}")
    public Procedures getProcedureById(@PathVariable Integer id) {
        return proceduresService.getProcedureById(id);
    }

    @PutMapping("/{id}")
    public Procedures updateProcedure(@PathVariable Integer id, @RequestBody Procedures procedures) {
        return proceduresService.updateProcedure(id, procedures);
    }

    @DeleteMapping("/{id}")
    public String deleteProcedure(@PathVariable Integer id) {
        proceduresService.deleteProcedure(id);
        return "Procedure deleted successfully";
    }
}