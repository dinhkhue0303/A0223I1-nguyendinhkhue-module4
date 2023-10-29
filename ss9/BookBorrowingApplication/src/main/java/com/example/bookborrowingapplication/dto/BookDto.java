package com.example.bookborrowingapplication.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookDto implements Validator {
    private int id;
    private String name;
    private String author;
    private int amount;
    private String image;
    private String[] codeBook;

    public BookDto() {
    }

    public BookDto(int id, String name, String author, int amount, String image, String[] codeBook) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.amount = amount;
        this.image = image;
        this.codeBook = codeBook;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String[] codeBook) {
        this.codeBook = codeBook;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
