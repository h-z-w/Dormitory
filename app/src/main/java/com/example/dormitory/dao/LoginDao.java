package com.example.dormitory.dao;


import com.example.dormitory.model.Login;
import com.example.dormitory.model.Student;

import java.util.List;

public interface LoginDao {
    List<Login> selectAllLogins();

    //条件查询
    Login select(String userName);

    //查询
    List<Login> selectAll();
    //条件查询
//    Student select(String xh);
//    List<Student> select(String name);

    //添加
    void insert(Login login);


    void update(Login login);
    void delete(String xh);

    Login selectByUserName(String username);
}
