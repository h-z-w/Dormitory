package com.example.dormitory.ui;




import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dormitory.R;

import java.util.ArrayList;
import java.util.List;

public class MarkFragment extends Fragment  {


    private static final String ARG_PARAM1 = "param1";
    private String mParam1;


    private OnFragmentInteractionListener mListener;

    public MarkFragment() {
    }


    public static MarkFragment newInstance(String param1) {
        MarkFragment fragment = new MarkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        super.onCreate(savedInstanceState);

    }

    private View view;
    private ListView lv2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mark, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "得分信息");

        if (view == null){
            view = inflater.inflate(R.layout.fragment_mark,container,false);
        }
        //0.获取数据
        initData();
        //1.初始化控件
        lv2 = view.findViewById(R.id.listView2);
        //2.创建Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,datas);
        //3.给ListView设置Adatper
        lv2.setAdapter(adapter);
        //4.给Item设置监听事件
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String data = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(),data,Toast.LENGTH_LONG).show();
                if("查看宿舍得分".equals(data)){
                    Intent intent=new Intent(getActivity(),Look4Activity.class);
                    intent.putExtra("title","查看宿舍得分");
                    startActivity(intent);
                }

            }
        });
        lv2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {
                datas.remove(parent.getItemAtPosition(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }


    private List<String> datas;

    //    private String[] datas = {"支付","收藏","相册","卡包","表情","设置"};
    private void initData() {
        datas = new ArrayList<>();
        datas.add("查看宿舍得分");



    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);

        void setActivityTitle(String data);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu( menu, inflater );
        inflater.inflate( R.menu.talk,menu);//菜单
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Toast.makeText( getActivity(),item.getTitle(),Toast.LENGTH_LONG ).show();
        }
        return super.onOptionsItemSelected( item );
    }

}


