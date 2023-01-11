package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();
    Song findBySongName(String songName);
    void deleteBySongName(String songName);
    void delete(Song song);
    void save(Song song);
    void edit(Song song);
}
