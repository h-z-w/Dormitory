package com.example.dormitory.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.RadioGroup;

import com.example.dormitory.R;

//1、注册 Fragment
//2、添加到fragment
//3、添加一个菜单  在menu中增加一个xml


public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener,
        InformationFragment.OnFragmentInteractionListener {

    //相当于java的HashMap
    private SparseArray<Fragment> fragments;
    //组
    private RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        initFragment();
        initView();

    }


    //按钮组
    private void initView() {
        group =findViewById( R.id.btn_group );
        group.setOnCheckedChangeListener( this );

    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        replaceFragment( fragments.get( checkedId ) );//id是RadioButton的id


    }



    private void initFragment() {
        //将创建的放入集合中，将页面定位为第一个Fragment
        fragments =new SparseArray<>(  );

        fragments.put( R.id.btn_zhuye,ZhuyeFragment.newInstance());
        fragments.put( R.id.btn_information,Information1Fragment.newInstance("activity向Find_fragment传递的数据") );
        fragments.put(R.id.btn_ping,MarkFragment.newInstance("activity向Find_fragment传递的数据"));


        //优先显示界面
        replaceFragment(fragments.get( R.id.btn_zhuye ));
    }



    //功能：对多个fragment进行管理和替换
    private void replaceFragment(Fragment fragment) {
        //1、获取对象
        FragmentManager manager =getSupportFragmentManager();
        //2、
        FragmentTransaction ft = manager.beginTransaction();
        //3、
        ft.replace( R.id.content_layout,fragment );
        //4、
        ft.commit();

    }


    @Override
    public void onFragmentInteraction(String data) {
        setTitle(data);
    }

    @Override
    public void setActivityTitle(String data) {
        setTitle(data);
    }
}
