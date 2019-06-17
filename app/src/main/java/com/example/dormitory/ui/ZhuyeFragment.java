package com.example.dormitory.ui;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dormitory.R;


public class ZhuyeFragment extends Fragment {



    public ZhuyeFragment() {
        // Required empty public constructor
    }

    public static ZhuyeFragment newInstance() {
        ZhuyeFragment fragment = new ZhuyeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate( R.layout.fragment_zhuye, container, false );
        setHasOptionsMenu( true );
//        Context context = getActivity();
//        if (context instanceof MeFragment.OnFragmentInteractionListener) {
//            listener = (OnDataCallbackListener) context;
//            if (listener!=null);{
//                listener.setActivityTitle(getResources().getString(R.string.wechat_fragment1));
//            }
//        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "主页" );
        return view;
    }




}
