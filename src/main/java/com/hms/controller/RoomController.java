package com.hms.controller;

import com.hms.entity.Room;
import com.hms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Integer roomNumber) {
        return roomService.getRoomById(roomNumber);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id") Integer roomNumber,
                           @RequestBody Room room) {
        return roomService.updateRoom(roomNumber, room);
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable("id") Integer roomNumber) {
        roomService.deleteRoom(roomNumber);
        return "Room deleted successfully";
    }
}