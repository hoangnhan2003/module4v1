package com.example.repository.Impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;

import static com.example.repository.Impl.BaseRepository.sessionFactory;

@Repository
public class SongRepository implements ISongRepository {


    @Override
    public List<Song> getAll() {
//        BaseRepository.entityManager.unwrap(Session.class).getSessionFactory().getCache().evictAllRegions();
        List<Song> songList = BaseRepository.getEntityManager().createQuery("select s from Song as s",Song.class).getResultList();
        return songList;
    }

    @Override
    public void save(Song newSong) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(newSong);
        entityTransaction.commit();

    }

    @Override
    public void delete(Song song) {
        BaseRepository.entityManager.createQuery("delete from Song as s where s.songName = ?1", Song.class).setParameter(1,song.getSongName()).executeUpdate();
    }

    @Override
    public void delete(String nameSong) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.createQuery("delete from Song s where s.songName = :songName").setParameter("songName",nameSong).executeUpdate();
        entityTransaction.commit();

    }

    @Override
    public Song findSongName(String songName) {
        Song song;
        song = BaseRepository.entityManager.createQuery("select s from Song as s where s.songName = ?1", Song.class).setParameter(1,songName).getSingleResult();
        return song;
    }

    @Override
    @Transactional
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        try{
            BaseRepository.entityManager.createQuery("update Song s set s.songName = :songName,s.singer = :singer,s.kindOfMusic = :kindOfMusic,s.filePath = :filePath where s.songName = :songName1"
                            )
                    .setParameter("songName",song.getSongName())
                    .setParameter("singer",song.getSinger()).setParameter("kindOfMusic",song.getKindOfMusic())
                    .setParameter("filePath",song.getFilePath())
                    .setParameter("songName1",song.getSongName()).executeUpdate();

        } catch (Exception e){
            entityTransaction.rollback();
        }
        entityTransaction.commit();

    }
}
