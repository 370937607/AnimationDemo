package com.example.linshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_class,btn_tools;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        btn_class=findViewById(R.id.btn_class);
        btn_tools=findViewById(R.id.btn_tools);
        textView = findViewById(R.id.tx_welcome);
        btn_class.setOnClickListener(this);
        btn_tools.setOnClickListener(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String name1 = "欢迎"+name+"来到本界面";
        textView.setText(name1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_class:
                Intent  intent= new Intent(PageActivity.this,ClassActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tools:
                Intent  intent2= new Intent(PageActivity.this,ToolsActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
