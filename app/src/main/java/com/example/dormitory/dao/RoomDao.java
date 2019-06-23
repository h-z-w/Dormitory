package com.example.dormitory.dao;

import java.util.List;

import com.example.dormitory.model.Room;

public interface RoomDao {
    // 查询所有的宿舍
    List<Room> selectAllRooms();

    // 根据宿舍名查询
    Room select(String roomName);

    // 查询所有未住满的宿舍
    List<Room> selectByNumber();

    // 增删改一个宿舍
    void insert(Room room);
    void update(Room room);
    void delete(int roomName);
}
