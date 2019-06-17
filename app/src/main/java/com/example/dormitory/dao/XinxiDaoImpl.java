package com.example.dormitory.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormitory.model.Xinxi;
import com.example.dormitory.util.Util;

import java.util.ArrayList;
import java.util.List;

public class XinxiDaoImpl implements XinxiDao{
    private SQLiteDatabase db;
    private Util helper;
    public XinxiDaoImpl(Context context){
        //调用Util类的构造方法时，如发现demo.db不存在会调用omCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper = new Util(context,1);

    }
    @Override
    public List<Xinxi> selectAllXinxi() {
        List<Xinxi> xinxis =null;
        //1.获取
//        db = helper.getReadableDatabase();
//        //2.查询
//        String sql = "select * from xinxi";
//        Cursor cursor = db.rawQuery(sql,null);
//        //3.处理结果
//        if (cursor != null&& cursor.getCount() >0){
//            xinxis = new ArrayList<>();
//            while (cursor.moveToNext()){
//                Xinxi xinxi = new Xinxi();
//                xinxi.setId(cursor.getInt(cursor.getColumnIndex("id")));
//                xinxi.setName(cursor.getString(cursor.getColumnIndex("name")));
//                xinxi.setClassName(cursor.getString(cursor.getColumnIndex("classname")));
//                xinxi.setXh(cursor.getInt(cursor.getColumnIndex("xh")));
//                xinxi.setSex(cursor.getString(cursor.getColumnIndex("sex")));
//                xinxi.setShuShe(cursor.getInt(cursor.getColumnIndex("shuse")));
//                xinxi.setTel(cursor.getString(cursor.getColumnIndex("tel")));
//                xinxi.setSubmissionDate(cursor.getString(cursor.getColumnIndex("submissionDate")));
//                xinxis.add(xinxi);
//            }
//            cursor.close();
//        }
//        db.close();
        //4.返回
        return xinxis;
    }

    @Override
    public void insert(Xinxi xinxi) {
        //1.获取db对象
        db = helper.getWritableDatabase();
        String sql = "insert into xinxi values(null,?,?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{xinxi.getName(),
                xinxi.getClassName(),
        xinxi.getXh(),xinxi.getSex(),xinxi.getShuShe(),xinxi.getTel(),xinxi.getSubmissionDate()});
        db.close();
    }

    @Override
    public void update(Xinxi xinxi) {
        db = helper.getWritableDatabase();
        String sql = "update  xinxi set shuse=? where name=?";
        db.execSQL(sql,new Object[]{xinxi.getName(),
                xinxi.getClassName(),
                xinxi.getXh(),xinxi.getSex(),xinxi.getShuShe(),xinxi.getTel(),xinxi.getSubmissionDate()});
    }

    @Override
    public void delete(String name) {
        db = helper.getWritableDatabase();
        String sql = "delete from xinxi where name=?";
        db.execSQL(sql,new Object[]{name});

    }
}
