package com.example.dormitory.dao;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormitory.model.Login;
import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;
import com.example.dormitory.util.Util;

import java.util.ArrayList;
import java.util.List;

public class SorceDaoImpl implements SorceDao{
    private SQLiteDatabase db;
    private Util helper;
    public SorceDaoImpl(Context context){
        //调用Util类的构造方法时，如发现demo.db不存在会调用omCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper = Util.getInstance(context);

    }
    @Override
    public List<Sorce> selectAllsorce() {
        List<Sorce> sorces =null;
        //1.获取
        db = helper.getReadableDatabase();
        //2.查询
        String sql = "select * from sorce";
        Cursor cursor = db.rawQuery(sql,null);
        //3.处理结果
        if (cursor != null&& cursor.getCount() >0){
            sorces = new ArrayList<>();
            while (cursor.moveToNext()){
                Sorce sorce = new Sorce();
                sorce.setId(cursor.getInt(cursor.getColumnIndex("id")));
                sorce.setSushe(cursor.getInt(cursor.getColumnIndex("sushe")));
                sorce.setMarks(cursor.getInt(cursor.getColumnIndex("marks")));
                sorce.setData(cursor.getString(cursor.getColumnIndex("submission_date")));
                sorces.add(sorce);
            }
            cursor.close();
        }
        db.close();
        //4.返回
        return sorces;
    }

    @Override
    public void insert(Sorce sorce) {
        //1.获取db对象
        db = helper.getWritableDatabase();
        String sql = "insert into sorce values(null,?,?,?)";
        db.execSQL(sql,new Object[]{
                sorce.getSushe(),
                sorce.getMarks(),
                sorce.getData()});
        db.close();
    }

    @Override
    public void insert(Login login) {

    }

    @Override
    public void update(Sorce sorce) {
        db = helper.getWritableDatabase();
        String sql = "update  sorce set marks=? where sushe=?";
        db.execSQL(sql,new Object[]{
                sorce.getMarks(),
                sorce.getSushe()});
    }

    @Override
    public void delete(int sushe) {
        db = helper.getWritableDatabase();
        String sql = "delete from sorce where sushe=?";
        db.execSQL(sql,new Object[]{sushe});

    }
}
