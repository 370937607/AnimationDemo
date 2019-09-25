package com.example.cache1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable bg = getResources().getDrawable(R.drawable.btn_login);
        bg.setColorFilter(Color.parseColor("#C7C7C7"), PorterDuff.Mode.MULTIPLY);
        ((View)findViewById(R.id.ll).getParent()).setBackground(bg);

    }
}
