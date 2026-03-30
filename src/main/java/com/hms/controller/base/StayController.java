package com.hms.controller.base;

import com.hms.entity.Stay;
import com.hms.service.base.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stays")
public class StayController {

    @Autowired
    private StayService stayService;

    @GetMapping
    public List<Stay> getAllStays() {
        return stayService.getAllStays();
    }

    @GetMapping("/{id}")
    public Stay getStayById(@PathVariable Integer id) {
        return stayService.getStayById(id);
    }

    @PostMapping
    public Stay createStay(@RequestBody Stay stay) {
        return stayService.saveStay(stay);
    }

    @PutMapping("/{id}")
    public Stay updateStay(@PathVariable Integer id,
                           @RequestBody Stay stay) {
        return stayService.updateStay(id, stay);
    }

    @DeleteMapping("/{id}")
    public String deleteStay(@PathVariable Integer id) {
        stayService.deleteStay(id);
        return "Stay deleted successfully";
    }
}