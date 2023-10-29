package com.example.image.service;

import com.example.image.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ICommentService {
    void save(Comment comment);
    Comment findById(Integer id);
    Page<Comment> findAll(Pageable pageable);
}
