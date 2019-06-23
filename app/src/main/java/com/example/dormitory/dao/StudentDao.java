package com.example.dormitory.dao;

import com.example.dormitory.model.Login;
import com.example.dormitory.model.Student;

import java.util.List;

public interface StudentDao {
    //查询
    List<Student> selectAll();
    //条件查询
//    Student select(String xh);
//    List<Student> select(String name);

    //添加
    void insert(Student student);

    void insert(Login login);

    void update(Student student);
    void delete(int xh);
}
