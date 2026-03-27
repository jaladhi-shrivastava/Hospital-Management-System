package com.hms.service;

import com.hms.entity.Room;
import java.util.List;

public interface RoomService {

    Room saveRoom(Room room);

    List<Room> getAllRooms();

    Room getRoomById(Integer roomNumber);

    Room updateRoom(Integer roomNumber, Room room);

    void deleteRoom(Integer roomNumber);
}