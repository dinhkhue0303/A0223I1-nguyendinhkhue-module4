package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> display();
    void add(Student student);
    Student find(int id);
}
