package com.hms.controller.base;

import com.hms.entity.TrainedIn;
import com.hms.entity.TrainedInId;
import com.hms.service.base.TrainedInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trained-in")
@RequiredArgsConstructor
public class TrainedInController {

    private final TrainedInService trainedInService;

    @GetMapping
    public ResponseEntity<List<TrainedIn>> getAll() {
        return ResponseEntity.ok(trainedInService.getAllTrainedIn());
    }

    @GetMapping("/physician/{physicianId}")
    public ResponseEntity<List<TrainedIn>> getByPhysician(
            @PathVariable Integer physicianId) {
        return ResponseEntity.ok(trainedInService.getByPhysician(physicianId));
    }

    @GetMapping("/procedure/{code}")
    public ResponseEntity<List<TrainedIn>> getByProcedure(@PathVariable Integer code) {
        return ResponseEntity.ok(trainedInService.getByProcedure(code));
    }

    @PostMapping
    public ResponseEntity<TrainedIn> create(@RequestBody TrainedIn trainedIn) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trainedInService.saveTrainedIn(trainedIn));
    }

    @PutMapping
    public ResponseEntity<TrainedIn> update(
            @RequestParam Integer physicianId,
            @RequestParam Integer treatmentCode,
            @RequestBody TrainedIn updated) {
        TrainedInId id = new TrainedInId(physicianId, treatmentCode);
        return ResponseEntity.ok(trainedInService.updateCertification(id, updated));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody TrainedInId id) {
        trainedInService.deleteTrainedIn(id);
        return ResponseEntity.noContent().build();
    }
}
