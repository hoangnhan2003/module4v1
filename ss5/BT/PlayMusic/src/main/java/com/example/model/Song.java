package com.example.model;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Song {
    @Id
    @Size(max = 300,message = "max length 50 characters")
    @NotEmpty(message = "song name mustn't null")
    private String songName;
    @Size(min = 1,max = 100,message = "max length 100 characters")
    @NotBlank(message = "singer is not blank")
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
