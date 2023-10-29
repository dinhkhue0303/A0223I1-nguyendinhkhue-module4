package com.example.validatebh.service;

import com.example.validatebh.model.Song;
import com.example.validatebh.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository iSongRepository;
    @Override
    public List<Song> display() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }
}
