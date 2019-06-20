package com.example.dormitory.service;

import android.content.Context;

import com.example.dormitory.dao.StudentDao;
import com.example.dormitory.dao.StudentDaoImpl;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    public StudentServiceImpl(Context context) {
        studentDao = new StudentDaoImpl(context);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.selectAll();
    }


    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void delete(int shushe) {
        studentDao.delete(String.valueOf(shushe));
    }

    public void modify(Student student) {
        studentDao.update(student);
    }

    @Override
    public void modify(int parseInt) {

    }
}