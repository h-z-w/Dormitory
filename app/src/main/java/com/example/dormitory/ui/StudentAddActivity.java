package com.example.dormitory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dormitory.R;
import com.example.dormitory.adapter.xinxiAdapter;
import com.example.dormitory.model.Student;
import com.example.dormitory.model.Xinxi;
import com.example.dormitory.service.StudentService;
import com.example.dormitory.service.XinxiService;

import java.util.List;

public class StudentAddActivity extends AppCompatActivity {
    private StudentService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        initView();

        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 把所有的输入数据封装成对象
                Student student = new Student();

                // 2. 传给数据库保存
                service.insert(student);
                //3. 返回到列表界面
                Intent intent= new Intent(StudentAddActivity.this,Look2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
    }


}
