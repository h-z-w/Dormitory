package com.example.dormitory.service;

import android.content.Context;

import com.example.dormitory.dao.StudentDao;
import com.example.dormitory.dao.XinxiDao;
import com.example.dormitory.dao.StudentDaoImpl;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.Student;
import com.example.dormitory.model.Xinxi;

import java.util.List;

public interface StudentService {
     List<Student> getAllStudents();
    void insert(Student student);
    void delete(int shushe);
     void modify(Student student);
}
