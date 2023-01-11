package com.example.repository;

import com.example.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> getAll();
    void save(Song newSong);
    void delete(Song song);
    void delete(String nameSong);
    Song findSongName(String songName);
    void update(Song song);

}
