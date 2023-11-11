package com.example.service;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> display() {
        return iStudentRepository.display();
    }

    @Override
    public void add(Student student) {
        iStudentRepository.add(student);
    }

    @Override
    public Student find(int id) {
        return iStudentRepository.find(id);
    }
}
