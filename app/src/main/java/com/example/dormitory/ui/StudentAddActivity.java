package com.example.dormitory.ui;

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
import com.example.dormitory.model.Student;
import com.example.dormitory.service.RoomService;
import com.example.dormitory.service.RoomServiceImpl;
import com.example.dormitory.service.StudentService;
import com.example.dormitory.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentAddActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSave, btnCancel;
    private EditText etName, etClassroom;
    private EditText etxh;
    private EditText ettel,ettime;
    private Spinner spshushe, spRoomSex;

    private List<String> sexes;
    private Student student;
    private List<Room> rooms;
    private String flag;
    private List<Integer> roomNumbers;
    private StudentServiceImpl studentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);

        studentService = new StudentServiceImpl(this);

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
        etName = findViewById(R.id.name);
        spRoomSex = findViewById(R.id.sex);
        etClassroom = findViewById(R.id.classroom);
        spshushe = findViewById(R.id.sushe);
        ettel = findViewById(R.id.tel);
        ettime = findViewById(R.id.time);
        etxh = findViewById(R.id.xh);

        btnSave = findViewById(R.id.btn_save);
        btnCancel = findViewById(R.id.btn_cancel);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        sexes = Arrays.asList(getResources().getStringArray(R.array.sex));
        spRoomSex.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                sexes));

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
            student = (Student) bundle.getSerializable("room");
            if(student != null) {
                etName.setText(student.getName());
                etName.setEnabled(false);
                etClassroom.setText(String.valueOf(student.getClassName()));
                ettel.setText(String.valueOf(student.getTel()));
                ettime.setText(String.valueOf(student.getSubmissionDate()));
                etxh.setText(String.valueOf(student.getXh()));

                int roomNumber = Integer.valueOf(etxh.getText().toString());
                int index = getSelectedIndex(roomNumber);
                spshushe.setSelection(index == -1 ? 0 : index, true);
                spRoomSex.setSelection(sexes.indexOf(student.getSex()), true);
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                updateStudentInfo();
                break;
            case R.id.btn_cancel:
                finish();
        }
    }

    private void updateStudentInfo() {
        if(student == null) {
            student = new Student();
        }
        student.setName(etName.getText().toString());
        student.setXh(Integer.valueOf(etxh.getText().toString()));
        student.setClassName(etClassroom.getText().toString());
        student.setSex((String) spRoomSex.getSelectedItem());
        student.setTel(ettel.getText().toString());
        student.setSubmissionDate(ettime.getText().toString());
        student.setShuShe(Integer.valueOf(spshushe.getSelectedItem().toString()));

        if("修改".equals(flag)) {
            studentService.modify(student);
        } else if("添加".equals(flag)) {
            studentService.insert(student);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("student", student);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
