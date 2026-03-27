package com.hms.controller;

import com.hms.entity.Undergoes;
import com.hms.entity.UndergoesId;
import com.hms.service.UndergoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/undergoes")
@CrossOrigin("*")
public class UndergoesController {

    @Autowired
    private UndergoesService undergoesService;

    @PostMapping
    public Undergoes createUndergoes(@RequestBody Undergoes undergoes) {
        return undergoesService.saveUndergoes(undergoes);
    }

    @GetMapping
    public List<Undergoes> getAllUndergoes() {
        return undergoesService.getAllUndergoes();
    }

    @GetMapping("/{patient}/{procedures}/{stay}/{dateUndergoes}")
    public Undergoes getUndergoesById(
            @PathVariable Integer patient,
            @PathVariable Integer procedures,
            @PathVariable Integer stay,
            @PathVariable String dateUndergoes
    ) {
        UndergoesId id = new UndergoesId(
                patient,
                procedures,
                stay,
                LocalDateTime.parse(dateUndergoes)
        );

        return undergoesService.getUndergoesById(id);
    }

    @DeleteMapping("/{patient}/{procedures}/{stay}/{dateUndergoes}")
    public String deleteUndergoes(
            @PathVariable Integer patient,
            @PathVariable Integer procedures,
            @PathVariable Integer stay,
            @PathVariable String dateUndergoes
    ) {
        UndergoesId id = new UndergoesId(
                patient,
                procedures,
                stay,
                LocalDateTime.parse(dateUndergoes)
        );

        undergoesService.deleteUndergoes(id);
        return "Undergoes record deleted successfully";
    }
}