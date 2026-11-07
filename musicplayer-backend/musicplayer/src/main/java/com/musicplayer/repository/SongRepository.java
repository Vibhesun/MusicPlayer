package com.musicplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicplayer.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByTitleContainingIgnoreCase(String title);

    List<Song> findByArtistContainingIgnoreCase(String artist);

    List<Song> findByGenreIgnoreCase(String genre);

    List<Song> findByAlbumContainingIgnoreCase(String album);
}