package com.example.service;

import com.example.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService{
    private static List<Person> list = new ArrayList<>();
    static {
    }

    @Override
    public List<Person> display() {
        return list;
    }

    @Override
    public void create(Person person) {
        list.add(person);
    }

    @Override
    public void update(String CMND,Person person) {
        for (Person p: list) {
            if(p.getCMND().equals(CMND)){
                BeanUtils.copyProperties(person,p);
            }
            break;
        }
    }

    @Override
    public Person findCMND(String CMND) {
        for (Person p: list) {
            if(p.getCMND().equals(CMND)){
                return p;
            }
        }
        return null;
    }

}
