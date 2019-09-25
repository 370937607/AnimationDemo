package edu.niit.android.wechat.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.niit.android.wechat.R;

public class ReceiveAddressActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_address);

        initData();
        initView();
    }

    private List<String> depts;
    private Map<String, Integer> majors;
    private void initData() {
        // 学院
        depts = new ArrayList<>();
        depts = Arrays.asList(getResources().getStringArray(R.array.dept_arr));
        // 专业
        majors = new HashMap<>();
        majors.put(depts.get(0), R.array.compute_dept_item);
        majors.put(depts.get(1), R.array.mechanical_dept_item);
    }

    private EditText etName;
    private EditText etPhone;
    private Spinner deptSpinner;
    private Spinner majorSpinner;
    private EditText etDetail;
    private Button btnSave;
    private void initView() {
        // 1. 设置标题和返回键
        Intent intent = getIntent();
        setTitle(intent.getStringExtra("title"));
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // 2. 初始化控件
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etDetail = findViewById(R.id.et_detail);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        deptSpinner = findViewById(R.id.dept_spinner);
        majorSpinner = findViewById(R.id.major_spinner);
        deptSpinner.setPrompt("选择院系");  // 没有数据的时候，显示的提示
        majorSpinner.setPrompt("选择专业");

        // 3. 设置spinner的adapter
        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, depts);
        deptAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deptSpinner.setAdapter(deptAdapter);
        deptSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dept = (String) parent.getItemAtPosition(position);
                ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(
                        ReceiveAddressActivity.this,
                        majors.get(dept),
                        android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String address = "收货地址：" + etName.getText() + ", " +
                etPhone.getText() + ", " +
                deptSpinner.getSelectedItem().toString() + ", " +
                majorSpinner.getSelectedItem().toString() + ", " +
                etDetail.getText();
        Toast.makeText(ReceiveAddressActivity.this, address, Toast.LENGTH_LONG).show();
    }
}
