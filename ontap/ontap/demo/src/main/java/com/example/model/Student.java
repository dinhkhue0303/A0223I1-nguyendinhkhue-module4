package com.example.model;

public class Student {
    private int id;
    private String name;
    private String className;
    private int gender;
    private String[] language;

    public Student() {
    }

    public Student(String name, String className, int gender, String[] language) {
        this.name = name;
        this.className = className;
        this.gender = gender;
        this.language = language;
    }

    public Student(int id, String name, String className, int gender, String[] language) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.gender = gender;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }
}
