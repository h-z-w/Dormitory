package com.example.dormitory.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormitory.model.Login;
import com.example.dormitory.model.Student;
import com.example.dormitory.util.Util;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private SQLiteDatabase db;
    private Util helper;
    public StudentDaoImpl(Context context){
        //调用Util类的构造方法时，如发现demo.db不存在会调用omCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper = Util.getInstance(context);

    }
    @Override
    public List<Student> selectAll() {
        List<Student> students =null;
        //1.获取
        db = helper.getReadableDatabase();
        //2.查询
        String sql = "select * from student";
        Cursor cursor = db.rawQuery(sql,null);
        //3.处理结果
        if (cursor != null&& cursor.getCount() >0){
            students = new ArrayList<>();
            while (cursor.moveToNext()){
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex("id")));
                student.setName(cursor.getString(cursor.getColumnIndex("name")));
                student.setClassName(cursor.getString(cursor.getColumnIndex("classroom")));
                student.setXh(cursor.getInt(cursor.getColumnIndex("xh")));
                student.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                student.setShuShe(cursor.getInt(cursor.getColumnIndex("sushe")));
                student.setTel(cursor.getString(cursor.getColumnIndex("tel")));
                student.setSubmissionDate(cursor.getString(cursor.getColumnIndex("submission_date")));
                students.add(student);
            }
            cursor.close();
        }
        db.close();
        //4.返回
        return students;
    }

    @Override
    public void insert(Student student) {
        //1.获取db对象
        db = helper.getWritableDatabase();
        String sql = "insert into student values(null,?,?,?,?,?,?,?)";
        db.execSQL(sql,new Object[]{
                student.getName(),
                student.getClassName(),
                student.getXh(),
                student.getSex(),
                student.getShuShe(),
                student.getTel(),
                student.getSubmissionDate()});
        db.close();
    }

    @Override
    public void insert(Login login) {

    }

    @Override
    public void update(Student student) {
        db = helper.getWritableDatabase();
        String sql = "update  student set sushe=? where name=?";
        db.execSQL(sql,new Object[]{
                student.getShuShe(),
                student.getName()});
    }

    @Override
    public void delete(int xh) {
        db = helper.getWritableDatabase();
        String sql = "delete from student where xh=?";
        db.execSQL(sql,new Object[]{xh});

    }
}
