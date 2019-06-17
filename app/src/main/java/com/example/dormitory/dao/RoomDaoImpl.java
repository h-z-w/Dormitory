package com.example.dormitory.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.dormitory.model.Room;
import com.example.dormitory.util.Util;

public class RoomDaoImpl implements RoomDao {
    private Util dbHelper;
    private SQLiteDatabase db;

    public RoomDaoImpl(Context context) {
        // 调用MyDBHelper类的构造方法时，
        // 若发现demo.db不存在会调用onCreate方法创建
        // 若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        dbHelper = new Util(context, 1);
    }

    public void insert(Room room) {
        db = dbHelper.getWritableDatabase();
        String sql = "insert into t_room values(null,?,?,?,?,?,?,?)";
        db.execSQL(sql, new Object[]{
                room.getName(),
                room.getClassroom(),
                room.getXh(),
                room.getSex(),
                room.getTel(),
                room.getShushe(),
                room.getData()});
        db.close();
    }

    @Override
    public void update(Room room) {
        // 1. 获取db对象
        db = dbHelper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update student set xh=? where name=?";
        db.execSQL(sql, new Object[]{
                room.getXh(),
                room.getName()
        });
    }

    @Override
    public void delete(String roomName) {
        // 1. 获取db对象
        db = dbHelper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from student where name=?";
        db.execSQL(sql, new Object[]{ roomName });
    }

    public List<Room> selectAllRooms() {
        String sql = "select * from student";
        List<Room> rooms = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            rooms = new ArrayList<>();
            while (cursor.moveToNext()) {
                Room room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setName(cursor.getString(cursor.getColumnIndex("name")));
                room.setClassroom(cursor.getString(cursor.getColumnIndex("classroom_sex")));
                room.setXh(cursor.getInt(cursor.getColumnIndex("xh")));
                room.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                room.setTel(cursor.getString(cursor.getColumnIndex("tel")));
                room.setShushe(cursor.getString(cursor.getColumnIndex("shushe")));
                room.setData(cursor.getString(cursor.getColumnIndex("data")));
                rooms.add(room);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return rooms;
    }

    @Override
    public Room select(String roomName) {
        String sql = "select * from t_room where room_name=?";
        Room room = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{roomName});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setName(cursor.getString(cursor.getColumnIndex("name")));
                room.setClassroom(cursor.getString(cursor.getColumnIndex("classroom_sex")));
                room.setXh(cursor.getInt(cursor.getColumnIndex("xh")));
                room.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                room.setTel(cursor.getString(cursor.getColumnIndex("tel")));
                room.setShushe(cursor.getString(cursor.getColumnIndex("shushe")));
                room.setData(cursor.getString(cursor.getColumnIndex("data")));
                 }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return room;
    }

    @Override
    public List<Room> selectByNumber() {
        String sql = "select * from student where expect_number > real_number";
        List<Room> rooms = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            rooms = new ArrayList<>();
            while (cursor.moveToNext()) {
                Room room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setName(cursor.getString(cursor.getColumnIndex("name")));
                room.setClassroom(cursor.getString(cursor.getColumnIndex("classroom_sex")));
                room.setXh(cursor.getInt(cursor.getColumnIndex("xh")));
                room.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                room.setTel(cursor.getString(cursor.getColumnIndex("tel")));
                room.setShushe(cursor.getString(cursor.getColumnIndex("shushe")));
                room.setData(cursor.getString(cursor.getColumnIndex("data")));
                rooms.add(room);;
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return rooms;
    }
}
