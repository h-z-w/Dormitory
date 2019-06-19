package com.example.dormitory.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dormitory.R;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dormitory.R;
import com.example.dormitory.model.Room;
import com.example.dormitory.model.Sorce;
import com.example.dormitory.model.Student;
import com.example.dormitory.service.RoomService;
import com.example.dormitory.service.RoomServiceImpl;
import com.example.dormitory.service.SorceServiceImpl;
import com.example.dormitory.service.StudentService;
import com.example.dormitory.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SorceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave, btnCancel;
    private EditText etmarks,etdata;
    private Spinner spshushe;


    private Sorce sorce;
    private List<Room> rooms;
    private String flag;
    private List<Integer> roomNumbers;
    private SorceServiceImpl sorceService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorce);

        sorceService = new SorceServiceImpl(this);

        initStudents();
        initView();
        initData();
    }

    private void initStudents() {
        RoomService service = new RoomServiceImpl(this);
        rooms = service.getAllRooms();

        roomNumbers = new ArrayList<>();
        if(rooms != null) {
            for(Room room : rooms) {
                roomNumbers.add(room.getSushe());
            }
        }
    }

    private int getSelectedIndex(int number) {
        for(int i = 0; i < roomNumbers.size(); i++) {
            if(roomNumbers.get(i) == number) {
                return i;
            }
        }
        return -1;
    }

    private void initView() {
        etdata = findViewById(R.id.data);
        etmarks = findViewById(R.id.marks);
        spshushe = findViewById(R.id.sushe);


        btnSave = findViewById(R.id.bt_save);
        btnCancel = findViewById(R.id.bt_cancel);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);


        spshushe.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                roomNumbers));
    }

    private void initData() {
        Intent intent = getIntent();
        flag = intent.getStringExtra("flag");

        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            sorce = (Sorce) bundle.getSerializable("room");
            if(sorce != null) {
//                etdata.setText(sorce.getData());
//                etName.setEnabled(false);
                etdata.setText(String.valueOf(sorce.getData()));
                etmarks.setText(String.valueOf(sorce.getMarks()));


                int roomNumber = Integer.valueOf(etmarks.getText().toString());
                int index = getSelectedIndex(roomNumber);
                spshushe.setSelection(index == -1 ? 0 : index, true);

            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_save:
                updateSorceInfo();
                break;
            case R.id.bt_cancel:
                finish();
        }
    }

    private void updateSorceInfo() {
        if(sorce == null) {
            sorce = new Sorce();
        }
        sorce.setData(etdata.getText().toString());
        sorce.setMarks(Integer.valueOf(etmarks.getText().toString()));
        sorce.setSushe(Integer.valueOf(spshushe.getSelectedItem().toString()));

        if("修改".equals(flag)) {
            sorceService.modify(sorce);
        } else if("添加".equals(flag)) {
            sorceService.insert(sorce);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("sorce", sorce);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}

