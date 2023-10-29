package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> display();
    void save(Blog blog);
    void delete(Integer id);
    Blog findById(Integer id);
}
