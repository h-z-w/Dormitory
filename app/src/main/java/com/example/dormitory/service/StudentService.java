package com.example.dormitory.service;

import android.content.Context;

import com.example.dormitory.dao.StudentDao;
import com.example.dormitory.dao.XinxiDao;
import com.example.dormitory.dao.StudentDaoImpl;
import com.example.dormitory.model.Student;
import com.example.dormitory.model.Xinxi;

import java.util.List;

public class StudentService {
    private Context context;
    private StudentDao studentDao;

    public StudentService(Context context) {
        this.context = context;
        studentDao = new StudentDaoImpl(context);
    }

    public List<Student> getAll() {
        return studentDao.selectAll();
    }

    public void insert(Student student) {
        studentDao.insert(student);
    }
}
