package com.example.dormitory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private Connection conn;

    public static Connection getConntion() {
        String url = "jdbc:mysql://127.0.0.1:3306/demo?" +
                "userUnicode=true&"+"serverTimezone=UTC";
        String user = "root";
        String password = "12345678";
        Connection conn = null;
        //1.加载数据库的jar驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args){
        Connection conn = DBUtil.getConntion();
        System.out.println(conn);
        DBUtil.close(conn);
    }}

