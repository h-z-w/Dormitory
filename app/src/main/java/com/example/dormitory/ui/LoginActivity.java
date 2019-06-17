package com.example.dormitory.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dormitory.R;
import com.example.dormitory.model.Login;
import com.example.dormitory.service.LoginService;
import com.example.dormitory.util.Util;


public class LoginActivity extends Activity {
    //定义控件变量名称
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnLogin1;
    private Button sign;
    private Util dbHelper;
    //2.获取用户名、密码的值
    //3.当登录按钮点击时，处理登录的逻辑
    //4.根据登录成功与否给出提示信息
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //1.获取用户名、密码和按钮这几个控件
        etUsername = findViewById(R.id.btn_username);
        etPassword = findViewById(R.id.btn_password);
        btnLogin = findViewById(R.id.btn_xuesheng);
        btnLogin1 = findViewById(R.id.btn_guanli);
        sign = findViewById(R.id.btn_zhuce);
        dbHelper = Util.getInstance(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameInfo = etUsername.getText().toString();
                String passwordInfo = etPassword.getText().toString();
                //从数据库中获取密码并判断是否相同
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select password from denglu where username=?", new String[]{nameInfo});
                String pi = null;
                if (cursor.moveToNext()) {
                    pi = cursor.getString(cursor.getColumnIndex("password"));//获取密码

                //密码正确跳转到登录后的界面
                if (passwordInfo.equals(pi)) {
                    Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                    startActivity(intent);
                    cursor.close();
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                } }else {
                    Toast.makeText(LoginActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();

                }


            }
        });

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String studentId = etUsername.getText().toString();
                String studentPassword = etPassword.getText().toString();
                if (!TextUtils.isEmpty(studentId) && !TextUtils.isEmpty(studentPassword)) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    Cursor cursor = db.rawQuery("select password from denglu where id=?", new String[]{studentId});
                    if (cursor.moveToNext()) {
                        String password = cursor.getString(cursor.getColumnIndex("password"));
                        if (password.equals(studentPassword)) {
                            //启动学生登录后的界面并将学生的账户（id）传过去
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("id", etUsername.getText().toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "密码错误请重新输入", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(LoginActivity.this, "没有该用户", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(LoginActivity.this, "帐户，密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //自定义AlertDialog用于注册
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                LayoutInflater factory = LayoutInflater.from(LoginActivity.this);
                final View textEntryView = factory.inflate(R.layout.activity_sign, null);
                builder.setTitle("用户注册");
                builder.setView(textEntryView);

                final EditText code = (EditText) textEntryView.findViewById(R.id.admin_register_info);
                final EditText name = (EditText) textEntryView.findViewById(R.id.admin_register_name);
                final EditText firstPassword = (EditText) textEntryView.findViewById(R.id.admin_register_first_password);
                final EditText secondPassword = (EditText) textEntryView.findViewById(R.id.admin_register_second_password);


                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String codeInfo = code.getText().toString();
                        //注册码要为10086
                        if (codeInfo.equals("10086")) {
                            String nameInfo = name.getText().toString();
                            String firstPasswordInfo = firstPassword.getText().toString();
                            String secondPasswordInfo = secondPassword.getText().toString();
                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            //检测密码是否为6个数字
                            if (firstPasswordInfo.matches("[0-9]{6}")) {
                                // 两次密码是否相同
                                if (firstPasswordInfo.equals(secondPasswordInfo)) {
                                    Cursor cursor = db.rawQuery("select username from denglu where username=? ", new String[]{nameInfo});
                                    //用户是否存在
                                    if (cursor.moveToNext()) {
                                        Toast.makeText(LoginActivity.this, "该用户已存在", Toast.LENGTH_SHORT).show();
                                    } else {
                                        db.execSQL("insert into denglu(username,password)values(?,?)", new String[]{nameInfo, firstPasswordInfo});
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "两次密码不相同", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "密码为6位纯数字", Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            Toast.makeText(LoginActivity.this, "注册码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                builder.create().show();

            }
        });


    }}