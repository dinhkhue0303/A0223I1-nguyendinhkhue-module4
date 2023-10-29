package com.example.validatebh.service;

import com.example.validatebh.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> display();
    void save(Song song);
    Song findById(Integer id);
}
