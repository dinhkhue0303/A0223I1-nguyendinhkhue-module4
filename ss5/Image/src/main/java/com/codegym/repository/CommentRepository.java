package com.codegym.repository;

import com.codegym.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CommentRepository implements ICommentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Comment> display() {
        TypedQuery<Comment> query = entityManager.createQuery("from Comment",Comment.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void save(Comment comment) {
        if(comment.getId() == null){
            entityManager.persist(comment);
        }else{
            comment.setNumberOfLike(comment.getNumberOfLike()+1);
            entityManager.merge(comment);
        }
    }

    @Override
    public void like(Integer id) {
        Comment comment = findById(id);

    }

    @Override
    public Comment findById(Integer id) {
        return entityManager.find(Comment.class,id);
    }

}
