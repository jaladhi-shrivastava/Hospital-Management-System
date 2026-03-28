package com.hms.controller;

import com.hms.entity.AffiliatedWith;
import com.hms.entity.AffiliatedWithId;
import com.hms.service.AffiliatedWithService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/affiliated-with")
@RequiredArgsConstructor
public class AffiliatedWithController {

    private final AffiliatedWithService affiliatedWithService;

    // GET /api/affiliated-with
    @GetMapping
    public ResponseEntity<List<AffiliatedWith>> getAll() {
        return ResponseEntity.ok(affiliatedWithService.getAll());
    }

    // GET /api/affiliated-with/physician/{physicianId}
    @GetMapping("/physician/{physicianId}")
    public ResponseEntity<List<AffiliatedWith>> getByPhysician(
            @PathVariable Integer physicianId) {
        return ResponseEntity.ok(affiliatedWithService.getByPhysician(physicianId));
    }

    // GET /api/affiliated-with/department/{departmentId}
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<AffiliatedWith>> getByDepartment(
            @PathVariable Integer departmentId) {
        return ResponseEntity.ok(affiliatedWithService.getByDepartment(departmentId));
    }

    // GET /api/affiliated-with/physician/{physicianId}/primary
    @GetMapping("/physician/{physicianId}/primary")
    public ResponseEntity<List<AffiliatedWith>> getPrimary(
            @PathVariable Integer physicianId) {
        return ResponseEntity.ok(
                affiliatedWithService.getPrimaryAffiliationsByPhysician(physicianId));
    }

    // POST /api/affiliated-with
    @PostMapping
    public ResponseEntity<AffiliatedWith> create(
            @RequestBody AffiliatedWith affiliatedWith) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(affiliatedWithService.save(affiliatedWith));
    }

    // PATCH /api/affiliated-with/physician/{pId}/department/{dId}/primary
    @PatchMapping("/physician/{pId}/department/{dId}/primary")
    public ResponseEntity<AffiliatedWith> updatePrimary(
            @PathVariable Integer pId,
            @PathVariable Integer dId,
            @RequestParam Boolean primary) {
        AffiliatedWithId id = new AffiliatedWithId(pId, dId);
        return ResponseEntity.ok(
                affiliatedWithService.updatePrimaryAffiliation(id, primary));
    }

    // DELETE /api/affiliated-with
    // Body: { "physician": 1, "department": 2 }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody AffiliatedWithId id) {
        affiliatedWithService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
