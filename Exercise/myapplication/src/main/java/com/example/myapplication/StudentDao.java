package com.example.myapplication;

import java.util.List;

public interface StudentDao {
    List<Student> selectAllStudent();
    void insert(Student student);
    void updata(Student student);
    void delete(String studentName);
}
