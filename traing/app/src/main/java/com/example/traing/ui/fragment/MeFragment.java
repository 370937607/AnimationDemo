package com.example.traing.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traing.R;


public class MeFragment extends Fragment {
    // 构造方法
    public MeFragment() {
        // Required empty public constructor
    }

    // 工厂方法
    public static MeFragment newInstance() {
        return new MeFragment();
    }

    // 相当于Activity的onCreate()的功能和作用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        // 显示选项菜单
        setHasOptionsMenu(true);


        return view;

    }
}
