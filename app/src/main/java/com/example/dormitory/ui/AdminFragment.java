package com.example.dormitory.ui;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dormitory.R;


public class AdminFragment extends Fragment {



    public AdminFragment() {
        // Required empty public constructor
    }

    public static AdminFragment newInstance() {
        AdminFragment fragment = new AdminFragment();

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
        View view= inflater.inflate( R.layout.fragment_admin, container, false );
        setHasOptionsMenu( true );
//        Context context = getActivity();
//        if (context instanceof MeFragment.OnFragmentInteractionListener) {
//            listener = (OnDataCallbackListener) context;
//            if (listener!=null);{
//                listener.setActivityTitle(getResources().getString(R.string.wechat_fragment1));
//            }
//        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle( "管理员信息" );
        return view;
    }




}
