package com.example.dormitory.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormitory.model.Login;
import com.example.dormitory.util.Util;

import java.util.ArrayList;
import java.util.List;

public abstract class LoginDaoImpl implements LoginDao {
    private Util helper;
    private SQLiteDatabase db;

    public LoginDaoImpl(Context context) {
        //调用MyDBHelper类的构造方法时，
        //若发现demo.db不存在会调用创建
        //若发现demo.db存在,且的版本与已有的一致，则调用onUpgrade方法更新
        helper = new Util(context, 1);
    }

    public LoginDaoImpl() {

    }

    @Override
    public List<Login> selectAllLogins() {
        List<Login> logins = null;
        //1.获取SQL
        db = helper.getReadableDatabase();
        //2.查询
        String sql = "select * from denglu";
        Cursor cursor = db.rawQuery(sql, null);//跟ResultSet类似
        //3.处理结果
        if (cursor != null && cursor.getCount() > 0) {
            logins = new ArrayList<>();
            while (cursor.moveToNext()) {
                Login login = new Login();
                login.setId(cursor.getInt(cursor.getColumnIndex("id")));
                login.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                login.setPassword(cursor.getString(cursor.getColumnIndex("password")));


                logins.add(login);
            }
            //4.关闭cursor
            cursor.close();
        }
        //5.返回
        return logins;
    }
    //条件查询
    @Override
    public Login select(String userName) {
        Login login = null;
        //1.获取SQL
        db = helper.getReadableDatabase();
        //2.查询
        String sql = "select * from denglu where username=?";
        Cursor cursor = db.rawQuery(sql, new String[]{userName});//跟ResultSet类似
        //3.处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                login = new Login();
                login.setId(cursor.getInt(cursor.getColumnIndex("id")));
                login.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                login.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            }
            //4.关闭cursor
            cursor.close();
        }
        //5.返回
        return login;
    }

    @Override
    public List<Login> selectAll() {
        return null;
    }

    //注册用户
    @Override
    public void insert(Login login) {
        db = helper.getWritableDatabase();
        String sql = "insert into denglu values(null,?,?,?)";
        db.execSQL(sql, new Object[]{
                login.getId(),
                login.getUsername(),
                login.getPassword()
        });
    }

    //修改
    @Override
    public void update(Login login) {

    }

    @Override
    public void delete(String userName) {
        //删除

    }
}
