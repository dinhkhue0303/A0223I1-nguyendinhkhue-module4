package com.example.bookborrowingapplication.repository;

import com.example.bookborrowingapplication.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findBookByNameContaining(Pageable pageable, String searchName);
}
