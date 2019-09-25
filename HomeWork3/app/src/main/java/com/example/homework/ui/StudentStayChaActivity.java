package com.example.homework.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.homework.R;
import com.example.homework.model.Room;
import com.example.homework.model.Student;
import com.example.homework.service.RoomService;
import com.example.homework.service.RoomServiceImpl;
import com.example.homework.service.StudentService;
import com.example.homework.service.StudentServiceImpl;

import java.util.Arrays;
import java.util.List;

public class StudentStayChaActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStudentSave, btnStudentCancel;
    private EditText etStudentRoom, etStudentName,etStudentyh;
    private EditText etStudentAge, etStudentNumber;
    private EditText etStudentRemark, etStudentMajor;
    private EditText etStudentInstitute, etStudentClass;

    private Student student;
    private StudentService studentService;
    private String flag1;

    private RadioGroup studentSex1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_stay_cha);


        studentService = new StudentServiceImpl(this);

        initView();
        initData();
    }

    private void initView() {
        etStudentyh=findViewById(R.id.et_student_yh);
        etStudentName = findViewById(R.id.et_student_name);
        etStudentNumber = findViewById(R.id.et_student_number);
        etStudentAge = findViewById(R.id.et_student_age);
        etStudentClass = findViewById(R.id.et_student_class);
        etStudentInstitute = findViewById(R.id.et_student_institute);
        etStudentMajor = findViewById(R.id.et_student_major);
        etStudentRoom = findViewById(R.id.et_student_room);
        etStudentRemark = findViewById(R.id.et_student_remark);
        studentSex1 = findViewById(R.id.student_sex1);

        btnStudentSave = findViewById(R.id.btn_student_save);
        btnStudentCancel = findViewById(R.id.btn_student_cancel);
        btnStudentSave.setOnClickListener(this);
        btnStudentCancel.setOnClickListener(this);


    }

    private void initData() {
        Intent intent = getIntent();
        flag1 = intent.getStringExtra("flag2");

        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            student = (Student) bundle.getSerializable("student2");
            if (student != null) {
                etStudentName.setText(student.getStudentName());
                etStudentyh.setText(String.valueOf(student.getUserName()));
                etStudentAge.setText(String.valueOf(student.getStudentAge()));
                etStudentNumber.setText(String.valueOf(student.getStudentNumber()));
                etStudentNumber.setEnabled(false);
                etStudentClass.setText(student.getStudentClassroom());
                etStudentInstitute.setText(student.getStudentInstitute());
                etStudentMajor.setText(student.getStudentMajor());
                etStudentRoom.setText(student.getStudentRoom());
                etStudentRemark.setText(student.getStudentRemark());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_student_save:
                updateStudent();

                break;
            case R.id.btn_student_cancel:
                finish();
        }
    }


    private String getRadioButtonValue(RadioGroup rg) {
        String result = null;
        int id = rg.getCheckedRadioButtonId();
        if(id == R.id.btn_male) {
            result = "男";
        } else if (id == R.id.btn_female) {
            result = "女";
        }
        return result;
    }
    private void updateStudent() {
        if (student == null) {
            student = new Student();
        }
        student.setUserName(etStudentyh.getText().toString());
        student.setStudentName(etStudentName.getText().toString());
        student.setStudentAge(Integer.valueOf(etStudentAge.getText().toString()));
        student.setStudentNumber(Integer.valueOf(etStudentNumber.getText().toString()));
        student.setStudentClassroom(etStudentClass.getText().toString());
        student.setStudentInstitute(etStudentInstitute.getText().toString());
        student.setStudentMajor(etStudentMajor.getText().toString());
        student.setStudentRoom(etStudentRoom.getText().toString());
        student.setStudentRemark(etStudentRemark.getText().toString());
        student.setStudentSex(getRadioButtonValue( studentSex1 ));

        if ("修改".equals(flag1)) {
            studentService.modifyRealNumber(student);
        } else if ("添加".equals(flag1)) {
            studentService.insert(student);
        }

        // 将修改的数据返回MainActivity
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("student2", student);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}