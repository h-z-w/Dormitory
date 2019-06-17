package com.example.dormitory.service;

import android.content.Context;

import java.util.List;

import com.example.dormitory.dao.RoomDao;
import com.example.dormitory.dao.RoomDaoImpl;
import com.example.dormitory.model.Room;

public class RoomServiceImpl implements RoomService{
    private RoomDao roomDao;

    public RoomServiceImpl(Context context) {
        roomDao = new RoomDaoImpl(context);
    }

    public List<Room> getAllRooms() {
        return roomDao.selectAllRooms();
    }

    public void insert(Room room) {
        roomDao.insert(room);
    }

    @Override
    public void modifyRealNumber(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(String roomName) {
        roomDao.delete(roomName);
    }
}
