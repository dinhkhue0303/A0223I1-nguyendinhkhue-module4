package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog> display() {
        TypedQuery<Blog> query = entityManager.createQuery("from Blog",Blog.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void save(Blog blog) {
        if(blog.getId() == null){
            entityManager.persist(blog);
        }else{
            entityManager.merge(blog);
        }
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        Blog blog = findById(id);
        entityManager.remove(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return entityManager.find(Blog.class,id);
    }
}
