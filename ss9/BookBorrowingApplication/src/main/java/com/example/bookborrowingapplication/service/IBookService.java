package com.example.bookborrowingapplication.service;

import com.example.bookborrowingapplication.exception.DuplicateNotExistCodeBookException;
import com.example.bookborrowingapplication.exception.DuplicateNumberEqualZeroException;
import com.example.bookborrowingapplication.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Page<Book> findAll(Pageable pageable, String searchName);
    void save(Book book);
    Book findById(int id);
    void borrowBook(Book book) throws DuplicateNumberEqualZeroException;
    void returnBook(String codeBook) throws DuplicateNotExistCodeBookException;
}
