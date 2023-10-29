package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> display();
    void add(Student student);
    Student find(int id);
}
