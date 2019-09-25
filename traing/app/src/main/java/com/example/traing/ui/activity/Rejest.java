package com.example.traing.ui.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traing.R;
import com.example.traing.bean.BmobUser;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class Rejest extends AppCompatActivity implements View.OnClickListener {

    private Button bt_break,bt_save,bt_yanzhengma;
    private EditText et_username,et_password,et_yanzhengma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regest);


        //隐藏自带标题栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }


        Bmob.initialize(this, "df59acdae2e6bfd468be00b11797dd66");



        initView();
        initData();





    }

    private void initData() {

        BmobUser user = new BmobUser();
        user.setUsername(et_username.getText().toString());
        user.setPassword(et_password.getText().toString());






//        // 修改标题
//        Intent intent = getIntent();
//        setTitle(intent.getStringExtra("返回"));
//
//        // 设置显示系统默认的返回键： <-
//        ActionBar actionBar = getSupportActionBar();
//        if(actionBar != null){
//            actionBar.setHomeButtonEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }


    }

    private void initView() {
//        bt_break = findViewById(R.id.btn_comback);
//        bt_save = findViewById(R.id.btn_save);
        bt_yanzhengma = findViewById(R.id.bt_yanzhengma);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_yanzhengma = findViewById(R.id.et_yanzhengma);
        bt_yanzhengma.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
//            case R.id.btn_save:
//                rejest();
//                break;
            case R.id.bt_yanzhengma:
                BmobSMS.requestSMSCode(et_username.getText().toString(), "sin", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer smsId, BmobException e) {
                        if (e == null) {
                            Toast.makeText(Rejest.this,"发送验证码成功，短信ID：" + smsId + "\n",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Rejest.this,"发送验证码失败：" + e.getErrorCode() + "-" + e.getMessage() + "\n",Toast.LENGTH_LONG).show();
                        }
                    }
                });
        }

    }

    private void rejest() {
        BmobSMS.verifySmsCode(et_username.getText().toString(), et_yanzhengma.getText().toString(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    BmobUser user = cn.bmob.v3.BmobUser.getCurrentUser(BmobUser.class);
                    user.setMobilePhoneNumber(Integer.parseInt(et_yanzhengma.getText().toString()));
                    user.setMobilePhoneNumberVerified(true);
                    user.update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                BmobUser user = new BmobUser();
                                user.setUsername(et_username.getText().toString());
                                user.setPassword(et_password.getText().toString());
                                user.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if(e!=null){
                                            Toast.makeText(Rejest.this,e.getMessage(),Toast.LENGTH_LONG).show();
                                        }else {
                                            Toast.makeText(Rejest.this,"success",Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
                            } else {
//                                mTvInfo.append("绑定手机号码失败：" + e.getErrorCode() + "-" + e.getMessage());
                            }
                        }
                    });
                } else {
//                    mTvInfo.append("验证码验证失败：" + e.getErrorCode() + "-" + e.getMessage() + "\n");
                }
            }
        });


    }
}
