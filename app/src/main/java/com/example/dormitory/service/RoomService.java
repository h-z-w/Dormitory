package com.example.dormitory.service;

import com.example.dormitory.model.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllRooms();
    public Room select(int roomName);
    public void insert(Room room);
    public void modifyRealNumber(Room room);
    public void delete(int roomName);
}
