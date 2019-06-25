package com.example.dormitory.service;

import com.example.dormitory.model.Student;

import java.util.List;

public interface StudentService {
     List<Student> getAllStudents();
    void insert(Student student);
    void delete(int xh);
     void modify(Student student);


    void modify(int parseInt);
}
