package com.example.dormitory.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dormitory.R;
import com.example.dormitory.util.Util;

public class ModifyActivity extends AppCompatActivity {
    private EditText jiu;
    private EditText xin;
    private EditText second;
    private Button save;
    private Util dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        jiu = findViewById(R.id.jiu);
        xin = findViewById(R.id.xin);
        second = findViewById(R.id.second);
        save = findViewById(R.id.queren);
        dbHelper = Util.getInstance(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            //密码的修改
            public void onClick(View v) {
                String oldPasswordInfo = jiu.getText().toString();
                String newPasswordInfo = xin.getText().toString();
                String reNewPasswordInfo = second.getText().toString();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (newPasswordInfo.equals(reNewPasswordInfo)) {

                    Cursor cursor = db.rawQuery("select username from denglu where password=? ", new String[]{oldPasswordInfo});
                    //判断用户是否存在，
                    if (cursor.moveToNext()) {
                        db.execSQL("update denglu set password=?  ", new String[]{newPasswordInfo});
                        Toast.makeText(ModifyActivity.this, "修改密码成功", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ModifyActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ModifyActivity.this, "原密码错误", Toast.LENGTH_LONG).show();

                    }

                } else {
                    Toast.makeText(ModifyActivity.this, "两次密码不正确，请重新输入", Toast.LENGTH_LONG).show();

                }

            }


        });
    }
}
