package com.example.dormitory.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dormitory.R;
import com.example.dormitory.adapter.StudentAdapter;
import com.example.dormitory.model.Student;
import com.example.dormitory.service.StudentService;
import com.example.dormitory.service.StudentServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LookActivity extends AppCompatActivity {

    private static final int ADD_REQUEST = 100;
    private static final int MODIFY_REQUEST = 101;

    private ListView studentList;
    private StudentAdapter studentAdapter;

    private StudentService studentService;
    private List<Student> students;
    private int selectedPos;
    private Student selectedStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        // 从SQLite数据库获取数据
        initData();

        // 初始化ListView
        studentList = findViewById(R.id.total_list_view);
        studentAdapter = new StudentAdapter(students);
        studentList.setAdapter(studentAdapter);

        // 设置ListView的点击和长按的事件监听
        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 将数据传递到StudentActivity界面显示
                selectedPos = position;
                selectedStudent = (Student) parent.getItemAtPosition(position);


                Intent intent = new Intent(LookActivity.this, StudentAddActivity.class);
                intent.putExtra("flag", "修改");
                Bundle bundle = new Bundle();
                bundle.putSerializable("student", (Serializable) selectedStudent);
                intent.putExtras(bundle);
                startActivityForResult(intent, MODIFY_REQUEST);
            }
        });
        studentList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // 弹出警告对话框，确认是否修改
                selectedStudent = (Student) parent.getItemAtPosition(position);

                new AlertDialog.Builder(LookActivity.this).setTitle("修改")
                        .setMessage("确认修改？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中修改
                                studentService.modify(Integer.parseInt(String.valueOf(selectedStudent.getShuShe())));
                                // 移除students中的数据，并刷新adapter
                                students.remove(position);
                                studentAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });
    }


    private void initData() {
        // 从SQLite数据库获取学生列表
        studentService = new StudentServiceImpl(this);

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if(students == null) {
            students = new ArrayList<>();
        }
    }

    // 接收StudentActivity的返回的添加或修改后的student对象，更新students，刷新列表
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            // 更新students列表
            selectedStudent = (Student) bundle.get("student");
            if (requestCode == MODIFY_REQUEST) {
                students.set(selectedPos, selectedStudent);
            } else if (requestCode == ADD_REQUEST) {
                students.add(selectedStudent);
            }
            // 刷新ListView
            studentAdapter.notifyDataSetChanged();
        }
    }
}
