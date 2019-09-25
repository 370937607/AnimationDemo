package com.example.homework.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework.R;
import com.example.homework.model.AdmCount;
import com.example.homework.model.Sign;
import com.example.homework.model.Sign2;
import com.example.homework.service.AdmService;
import com.example.homework.service.AdmServiceImpl;
import com.example.homework.service.Sign2Service;
import com.example.homework.service.SignService;

public class SafCountActivyty extends AppCompatActivity implements View.OnClickListener{

    private EditText upPasswordg,upPassword2g,upUsernameg;
    private Button updateg,upReturng;
    private TextView texxx;
    private SignService signService;
    private Sign sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saf_count);
        signService = new SignService(this);
        texxx=findViewById(R.id.texxx);
        upUsernameg= findViewById(R.id.up_usernameg);
        upPasswordg= findViewById(R.id.up_passwordg);
        upPassword2g= findViewById(R.id.up_password2g);
        updateg= findViewById(R.id.updateg);
        upReturng=findViewById(R.id.up_returng);
        updateg.setOnClickListener(this);
        upReturng.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.updateg:
                updataPassword();
                break;
            case R.id.up_returng:
                Intent intent1 = new Intent(SafCountActivyty.this,StudentAdministration2Fragment.class);
                startActivity(intent1);
                break;
        }
    }

    private void updataPassword() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("username1");


        Sign sign = new Sign();
        sign.setUsername(name);
        sign.setPassword(upUsernameg.getText().toString());
        // 2. 判断
        boolean result = signService.login(sign);


        if (sign == null) {
            sign = new Sign();
        }
        sign.setUsername(name);
        sign.setPassword(upPasswordg.getText().toString());

        if (result&&sign != null) {
            signService.modifyPassword(sign);
            Toast.makeText(SafCountActivyty.this,"修改成功",Toast.LENGTH_LONG).show();
        }
    }
}
