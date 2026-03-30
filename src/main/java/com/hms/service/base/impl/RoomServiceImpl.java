package com.hms.service.base.impl;

import com.hms.entity.Room;
import com.hms.repository.RoomRepository;
import com.hms.service.base.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Integer roomNumber) {
        return roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomNumber));
    }

    @Override
    public Room updateRoom(Integer roomNumber, Room room) {
        Room existingRoom = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomNumber));

        existingRoom.setRoomType(room.getRoomType());
        existingRoom.setUnavailable(room.getUnavailable());

        // Optional: update block if needed
        existingRoom.setBlock(room.getBlock());

        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Integer roomNumber) {
        Room existingRoom = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomNumber));

        roomRepository.delete(existingRoom);
    }
}