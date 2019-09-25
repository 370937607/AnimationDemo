package com.example.linshi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username,et_password;
    private Button btn_login,btn_break;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_break = findViewById(R.id.btn_break);

        btn_login.setOnClickListener(this);
        btn_break.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (username.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this,"请输入正确的账户或密码",Toast.LENGTH_LONG).show();
        }else {
                    Intent intent = new Intent(MainActivity.this,PageActivity.class);
                    intent.putExtra("name", username);
                    startActivity(intent);
                }
                break;
            case R.id.btn_break:
                finish();
                break;
        }

    }
}
