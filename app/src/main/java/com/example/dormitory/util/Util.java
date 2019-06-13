package com.example.dormitory.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

public class Util extends SQLiteOpenHelper {

    private final String TBL_Xinxi ="CREATE TABLE  xinxi(" +
            "  id integer PRIMARY KEY autoincrement ," +
            "  name VARCHAR(100) NOT NULL ," +
            "  classroom VARCHAR(40) NOT NULL ," +
            "  xh integer(10) NOT NULL ," +
            "  sex VARCHAR(40) NOT NULL ," +
            "  sushe integer(8) NOT NULL ," +
            "  tel varchar(11) NOT NULL ," +
            "  submission_date DATE )";
    public Util( Context context,int version) {
        super(context, "demo.db", null, version);
    }
//当app发现没有demo，db时会
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_Xinxi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int i1) {
        db.execSQL("drop table if exists xinxi" );
        onCreate(db);
    }
}
