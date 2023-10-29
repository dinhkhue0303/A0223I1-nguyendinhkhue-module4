package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable, String searchTitle);
    Page<Blog> findByCategory(Pageable pageable, Integer id_category);
    boolean save(Blog blog);

    Blog findById(Integer id);
    void remove(Integer id);
}
