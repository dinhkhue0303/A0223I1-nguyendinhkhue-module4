package com.example.repository;

import com.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    static List<Student> list = new ArrayList<>();
    static {
        list.add(new Student(1,"van a","cc0",1,new String[]{"JS","Java"}));
        list.add(new Student(2,"thuy linh","cc1",0,new String[]{"PHP","Java"}));
        list.add(new Student(3,"van c","cc2",1,new String[]{"SQL","Java"}));
    }
    @Override
    public List<Student> display() {
        return list;
    }

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public Student find(int id) {
        for (Student s:list) {
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
}
