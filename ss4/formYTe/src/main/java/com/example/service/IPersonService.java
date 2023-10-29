package com.example.service;

import com.example.model.Person;

import java.util.List;

public interface IPersonService {
    List<Person> display();
    void create(Person person);
    void update(String CMND,Person person);
    Person findCMND(String CMND);
}
