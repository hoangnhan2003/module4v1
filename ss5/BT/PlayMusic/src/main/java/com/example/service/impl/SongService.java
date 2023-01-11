package com.example.service.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> getAll() {
        return songRepository.getAll();
    }

    @Override
    public Song findBySongName(String songName) {
        return songRepository.findSongName(songName);
    }

    @Override
    public void deleteBySongName(String songName) {
        songRepository.delete(songName);
    }

    @Override
    public void delete(Song song) {
        songRepository.delete(song);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    @Transactional
    public void edit(Song song) {
        songRepository.update(song);
    }
}
