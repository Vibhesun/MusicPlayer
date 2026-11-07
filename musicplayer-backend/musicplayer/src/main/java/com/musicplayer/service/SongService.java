package com.musicplayer.service;

import java.util.List;
import java.util.Optional;
import com.musicplayer.entity.Song;

public interface SongService {
    Song saveSong(Song song);
    List<Song> getAllSongs();
    Optional<Song> getSongById(Long id);
    Song updateSong(Long id, Song song);
    void deleteSong(Long id);
    List<Song> searchByTitle(String title);
    List<Song> searchByArtist(String artist);
    List<Song> searchByGenre(String genre);
    List<Song> searchByAlbum(String album);
}