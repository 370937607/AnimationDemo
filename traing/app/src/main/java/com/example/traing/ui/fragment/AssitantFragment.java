package com.example.traing.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.traing.R;
import com.example.traing.ui.activity.RedyActivity;


public class AssitantFragment extends Fragment {
    private Button button;
    // 构造方法
    public AssitantFragment() {
        // Required empty public constructor
    }

    // 工厂方法
    public static AssitantFragment newInstance() {
        return new AssitantFragment();
    }

    // 相当于Activity的onCreate()的功能和作用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assitant, container, false);
        // 显示选项菜单
        setHasOptionsMenu(true);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.btn_newnote);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RedyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initDate() {
    }
}
