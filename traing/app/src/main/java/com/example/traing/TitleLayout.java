package com.example.traing;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_regest,this);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        Button btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_back.setOnClickListener(this);
        btn_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back:
                ((Activity)getContext()).finish();
                break;
            case R.id.btn_edit:
                Toast.makeText(getContext(),"you clicked Edit button",Toast.LENGTH_LONG).show();
                break;

        }


    }
}
