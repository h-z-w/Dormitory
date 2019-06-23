package com.example.dormitory.service;



import com.example.dormitory.dao.LoginDao;

import com.example.dormitory.dao.LoginDaoImpl;

import com.example.dormitory.model.Login;

import com.example.dormitory.ui.LoginActivity;



public class LoginService {

    private LoginDao loginDao = new LoginDaoImpl() {

        @Override

        public Login selectByUserName(String username) {

            return null;

        }

    };



    public LoginService(LoginActivity loginActivity) {



    }



    //1.完成登录功能

    public boolean login(Login user){

        //1.去数据库获取登录信息

        Login tmp = loginDao.selectByUserName(user.getUsername());

        //2.比较输入的密码和数据库保存的是否一致

        String password = null;



        password = user.getPassword();

        if (tmp != null&&tmp.getPassword().equals(password)) {

            return true;

        }



        //3.返回登录是否成功的true或false

        return false;



    }

}