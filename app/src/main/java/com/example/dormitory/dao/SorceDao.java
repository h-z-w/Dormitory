package com.example.dormitory.dao;

import com.example.dormitory.model.Login;
import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;

import java.util.List;

public interface SorceDao {
    //查询
    List<Sorce> selectAllsorce();
    //条件查询
//    Student select(String xh);
//    List<Student> select(String name);

    //添加
    void insert(Sorce sorce);

    void insert(Login login);

    void update(Sorce sorce);
    void delete(String sushe);
}