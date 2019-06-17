package com.example.dormitory.service;

import com.example.dormitory.model.Room;

import java.util.List;

import com.example.dormitory.model.Room;

public interface RoomService {
    public List<Room> getAllRooms();
    public void insert(Room room);
    public void modifyRealNumber(Room room);
    public void delete(String roomName);
}
