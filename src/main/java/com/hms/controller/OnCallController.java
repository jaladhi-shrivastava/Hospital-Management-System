package com.hms.controller;

import com.hms.entity.OnCall;
import com.hms.entity.OnCallId;
import com.hms.service.OnCallService;
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

    // GET /api/on-call
    @GetMapping
    public ResponseEntity<List<OnCall>> getAll() {
        return ResponseEntity.ok(onCallService.getAllOnCallRecords());
    }

    // GET /api/on-call/nurse/{nurseId}
    @GetMapping("/nurse/{nurseId}")
    public ResponseEntity<List<OnCall>> getByNurse(@PathVariable Integer nurseId) {
        return ResponseEntity.ok(onCallService.getOnCallByNurse(nurseId));
    }

    // GET /api/on-call/block/{floor}/{code}
    @GetMapping("/block/{floor}/{code}")
    public ResponseEntity<List<OnCall>> getByBlock(
            @PathVariable Integer floor,
            @PathVariable Integer code) {
        return ResponseEntity.ok(onCallService.getOnCallByBlock(floor, code));
    }

    // POST /api/on-call
    @PostMapping
    public ResponseEntity<OnCall> create(@RequestBody OnCall onCall) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(onCallService.saveOnCall(onCall));
    }

    // DELETE /api/on-call
    // Pass OnCallId as JSON body: { "nurse":1, "blockFloor":2, "blockCode":3 }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody OnCallId id) {
        onCallService.deleteOnCall(id);
        return ResponseEntity.noContent().build();
    }
}
