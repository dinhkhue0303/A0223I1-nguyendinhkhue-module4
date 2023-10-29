package com.example.image.service;

import com.example.image.model.Comment;
import com.example.image.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }


    @Override
    public Comment findById(Integer id) {
        return iCommentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return iCommentRepository.findAll(pageable);
    }
}
