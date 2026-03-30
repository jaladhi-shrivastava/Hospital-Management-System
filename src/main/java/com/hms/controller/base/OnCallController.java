package com.hms.controller.base;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import com.hms.service.base.OnCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/on-call")
@RequiredArgsConstructor
public class OnCallController {

    private final OnCallService onCallService;

    @GetMapping
    public ResponseEntity<List<OnCall>> getAll() {
        return ResponseEntity.ok(onCallService.getAllOnCallRecords());
    }

    @GetMapping("/nurse/{nurseId}")
    public ResponseEntity<List<OnCall>> getByNurse(@PathVariable Integer nurseId) {
        return ResponseEntity.ok(onCallService.getOnCallByNurse(nurseId));
    }

    @GetMapping("/block/{floor}/{code}")
    public ResponseEntity<List<OnCall>> getByBlock(
            @PathVariable Integer floor,
            @PathVariable Integer code) {
        return ResponseEntity.ok(onCallService.getOnCallByBlock(floor, code));
    }

    @PostMapping
    public ResponseEntity<OnCall> create(@RequestBody OnCall onCall) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(onCallService.saveOnCall(onCall));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody OnCallId id) {
        onCallService.deleteOnCall(id);
        return ResponseEntity.noContent().build();
    }
}
