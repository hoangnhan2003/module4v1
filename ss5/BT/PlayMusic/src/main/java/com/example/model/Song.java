package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Song {
    @Id
    private String songName;
    private String singer;
    private String kindOfMusic;
    private String filePath;

    public Song() {
    }

    public Song(String songName, String singer, String kindOfMusic, String filePath) {
        this.songName = songName;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.filePath = filePath;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
