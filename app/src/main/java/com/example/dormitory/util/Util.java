package com.example.dormitory.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dormitory.ui.LoginActivity;
import com.example.dormitory.ui.LookActivity;


public class Util extends SQLiteOpenHelper {
    private static Util instance;

    private final String TBL_STUDENT ="CREATE TABLE  student(" +
            "  id integer PRIMARY KEY autoincrement ," +
            "  name VARCHAR(100) NOT NULL ," +
            "  classroom VARCHAR(40) NOT NULL ," +
            "  xh integer(10) NOT NULL ," +
            "  sex VARCHAR(40) NOT NULL ," +
            "  sushe integer(8) NOT NULL ," +
            "  tel varchar(11) NOT NULL ," +
            "  submission_date DATE )";
    private final String TBL_Login ="CREATE TABLE  denglu("+
    "id integer PRIMARY KEY autoincrement ,"+
    "username VARCHAR(100) NOT NULL,"+
    "password VARCHAR(40) NOT NULL )";


    public Util( Context context,int version) {
        super(context, "demo.db", null, version);
    }

    public Util(LoginActivity loginActivity, String s, Object o, int i) {
        super(loginActivity, s, (SQLiteDatabase.CursorFactory) o, i);
    }

    public Util(LookActivity lookActivity, String s, Object o, int i) {
        super(lookActivity, s, (SQLiteDatabase.CursorFactory) o, i);
    }

    public static Util getInstance(LoginActivity loginActivity) {
        if (instance == null) {
            instance = new Util(loginActivity, "StudentManagement.db", null, 2);
        }
        return instance;
    }

    public static Util getInstance(LookActivity lookActivity) {
        if (instance == null) {
            instance = new Util(lookActivity, "StudentManagement.db", null, 2);
        }
        return instance;
    }


    //当app发现没有demo，db时会
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_STUDENT);
        db.execSQL(TBL_Login);
        db.execSQL("insert into denglu values(null, '1111', '1111')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int i1) {
        db.execSQL("drop table if exists student" );
        db.execSQL("drop table if exists denglu");
        onCreate(db);
    }
}
