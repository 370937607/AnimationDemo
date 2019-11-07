package com.example.traing.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.traing.R;
import com.example.traing.adatper.GridViewAdapter;
import com.example.traing.service.ThreeService;
import com.example.traing.ui.activity.RedyActivity;
import com.example.traing.ui.activity.tools.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

public class ToolsFragment extends Fragment {

    private View view;
    private ImageView imageView;



    // 构造方法
    public ToolsFragment() {
        // Required empty public constructor
    }

    // 工厂方法
    public static ToolsFragment newInstance() {
        return new ToolsFragment();
    }

    // 相当于Activity的onCreate()的功能和作用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        // 显示选项菜单
        setHasOptionsMenu(true);



        return view;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        initDate();
        initView();


    }


    private GridView gridView;


    // 给ThreeService集合赋值
    private List<ThreeService> services;
    private void initDate() {

        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.main_page_griditem_weather, "行程天气"));
        services.add(new ThreeService(R.mipmap.main_page_griditem_strategy_normal, "实时翻译"));
        services.add(new ThreeService(R.mipmap.main_page_grid_item_inner_spot_n, "国内景点"));
        services.add(new ThreeService(R.mipmap.main_page_griditem_travel_bill_normal, "记账本"));
        services.add(new ThreeService(R.mipmap.main_page_griditem_rate_normal, "汇率换算"));
        services.add(new ThreeService(R.mipmap.main_page_grid_item_insurance_n, "旅游保险"));
        services.add(new ThreeService(R.mipmap.main_page_grid_item_information_n, "旅行资讯"));
        services.add(new ThreeService(R.mipmap.main_page_griditem_help, "紧急救援"));
        services.add(new ThreeService(R.mipmap.main_page_griditem_strategy_normal, "出国攻略"));

    }



    private void initView() {
        gridView = getActivity().findViewById(R.id.gv);
        gridView.setAdapter(new GridViewAdapter(this, services));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ThreeService service = (ThreeService) parent.getItemAtPosition(position);
                        Intent intent = new Intent(getActivity(), WeatherActivity.class);
                        startActivity(intent);
                }
            }
        });



        imageView = getActivity().findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RedyActivity.class);
                startActivity(intent);
            }
        });

    }
}
