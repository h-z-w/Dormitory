package com.example.dormitory.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;
import com.example.dormitory.ui.LoginActivity;
import com.example.dormitory.ui.LookActivity;

import static com.example.dormitory.model.Room.TBL_ROOM;


public class Util extends SQLiteOpenHelper {
    private static Util instance;

    private final String TBL_Login ="CREATE TABLE  denglu("+
    "id integer PRIMARY KEY autoincrement ,"+
    "username VARCHAR(100) NOT NULL,"+
    "password VARCHAR(40) NOT NULL )";


    private Util( Context context,int version) {
        super(context, "demo.db", null, version);
    }

    public static Util getInstance(Context context) {
        if (instance == null) {
            instance = new Util(context, 7);
        }
        return instance;
    }

    //当app发现没有demo，db时会
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Student.TBL_STUDENT);
        db.execSQL(TBL_Login);
        db.execSQL(TBL_ROOM);
        db.execSQL(Sorce.TBL_SORCE);
        db.execSQL("insert into denglu values(null, '1111', '1111')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int i1) {
        db.execSQL("drop table if exists student" );
        db.execSQL("drop table if exists denglu");
        db.execSQL("drop table if exists room");
        db.execSQL("drop table if exists sorce");
        onCreate(db);
    }
}
