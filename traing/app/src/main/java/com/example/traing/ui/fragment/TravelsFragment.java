package com.example.traing.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traing.R;


public class TravelsFragment extends Fragment {
    // 构造方法
    public TravelsFragment() {
        // Required empty public constructor
    }

    // 工厂方法
    public static TravelsFragment newInstance() {
        return new TravelsFragment();
    }

    // 相当于Activity的onCreate()的功能和作用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travels, container, false);
        // 显示选项菜单
        setHasOptionsMenu(true);


        return view;

    }
}
