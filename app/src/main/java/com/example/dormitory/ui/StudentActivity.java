package com.example.dormitory.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dormitory.R;
import com.example.dormitory.adapter.xinxiAdapter;
import com.example.dormitory.model.Xinxi;
import com.example.dormitory.service.XinxiService;

import java.util.List;

public class StudentActivity extends AppCompatActivity {
    private XinxiService xinxiService;
    private ListView xinxiList;
    private List<Xinxi> xinxis;
    private Object xinxiAdapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        initData();
        xinxiList = findViewById(R.id.xinxi);
        xinxiAdapter = new xinxiAdapter(xinxis);
        xinxiList.setAdapter((ListAdapter) xinxiAdapter);

    }

    private void initData() {
        xinxiService = new XinxiService(this);
        Xinxi xinxi = new Xinxi("陈辰","移动1813",1802783110,"男",306,"12345678","2018.01.02");
        xinxiService.insert(xinxi);

    }
}
