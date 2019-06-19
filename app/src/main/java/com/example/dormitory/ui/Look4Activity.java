package com.example.dormitory.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dormitory.R;
import com.example.dormitory.adapter.SorceAdapter;
import com.example.dormitory.model.Sorce;
import com.example.dormitory.service.SorceService;
import com.example.dormitory.service.SorceServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Look4Activity extends AppCompatActivity {
    private static final int ADD_REQUEST = 100;
    private static final int MODIFY_REQUEST = 101;

    private ListView sorceList;
    private SorceAdapter sorceAdapter;

    private SorceService sorceService;
    private List<Sorce> sorces;
    private int selectedPos;
    private Sorce selectedSorce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look4);

        // 从SQLite数据库获取数据
        initData();

        // 初始化ListView
        sorceList = findViewById(R.id.list_sorce);
        sorceAdapter = new SorceAdapter(sorces);
        sorceList.setAdapter(sorceAdapter);

        // 设置ListView的点击和长按的事件监听
        sorceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 将数据传递到RoomActivity界面显示
                selectedPos = position;
                selectedSorce = (Sorce) parent.getItemAtPosition(position);

                Intent intent = new Intent(Look4Activity.this, SorceActivity.class);
                intent.putExtra("flag", "修改");

                Bundle bundle = new Bundle();
                bundle.putSerializable("room", selectedSorce);
                intent.putExtras(bundle);

                startActivityForResult(intent, MODIFY_REQUEST);
            }
        });
        sorceList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // 弹出警告对话框，确认是否删除
                selectedSorce = (Sorce) parent.getItemAtPosition(position);

                new AlertDialog.Builder(Look4Activity.this).setTitle("删除")
                        .setMessage("确认删除？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 从SQLite数据库的表中删除
                                sorceService.delete(selectedSorce.getSushe());
                                // 移除rooms中的数据，并刷新adapter
                                sorces.remove(position);
                                sorceAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                return true;
            }
        });
    }

    private void initData() {
        // 从SQLite数据库获取宿舍列表
        sorceService = new SorceServiceImpl(this);
        sorces = sorceService.getAllSorces();

        // 若数据库中没数据，则初始化数据列表，防止ListView报错
        if(sorces == null) {
            sorces = new ArrayList<>();
        }
    }

    // 接收RoomActivity的返回的添加或修改后的room对象，更新rooms，刷新列表
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
            // 更新rooms列表
            selectedSorce = (Sorce) bundle.get("sorce");
            if (requestCode == MODIFY_REQUEST) {
                sorces.set(selectedPos, selectedSorce);
            } else if (requestCode == ADD_REQUEST) {
                sorces.add(selectedSorce);
            }
            // 刷新ListView
            sorceAdapter.notifyDataSetChanged();
        }
    }

    // 创建添加功能的选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 动态加载菜单
        MenuItem item = menu.add(Menu.FIRST, 1, Menu.NONE, "添加");
        item.setIcon(android.R.drawable.ic_menu_add);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    // 处理选项菜单的添加功能
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                // 跳转到RoomActivity页面进行添加，flag用于存储是添加还是修改
                Intent intent = new Intent(Look4Activity.this, SorceActivity.class);
                intent.putExtra("flag", "添加");
                startActivityForResult(intent, ADD_REQUEST);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
