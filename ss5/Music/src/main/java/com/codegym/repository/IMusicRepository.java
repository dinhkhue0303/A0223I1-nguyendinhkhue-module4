package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> display();
    void save(Music music);
    Music findId(Integer id);
    void delete(Integer id);
}
