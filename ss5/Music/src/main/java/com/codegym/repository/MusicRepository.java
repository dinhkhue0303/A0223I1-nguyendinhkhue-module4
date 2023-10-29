package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class MusicRepository implements IMusicRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Music> display() {
        TypedQuery<Music> query = entityManager.createQuery("from Music",Music.class);
        return query.getResultList();
    }
    @Transactional
    @Override
    public void save(Music music) {
        if(music.getId() == null){
            entityManager.persist(music);
        }else{
            entityManager.merge(music);
        }
    }
    @Transactional
    @Override
    public Music findId(Integer id) {
        TypedQuery<Music> query = entityManager.createQuery("from Music where id=:id",Music.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        Music music = findId(id);
        if(music != null){
            entityManager.remove(music);
        }
    }

}
