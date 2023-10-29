package com.example.image.repository;

import com.example.image.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {
}
