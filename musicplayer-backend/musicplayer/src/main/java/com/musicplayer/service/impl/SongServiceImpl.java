package com.musicplayer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.musicplayer.entity.Song;
import com.musicplayer.exception.ResourceNotFoundException;
import com.musicplayer.repository.SongRepository;
import com.musicplayer.service.SongService;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song updateSong(Long id, Song song) {
        Song existing = songRepository.findById(id)
        		.orElseThrow(() ->
        	    new ResourceNotFoundException("Song not found with ID: " + id));

        existing.setTitle(song.getTitle());
        existing.setArtist(song.getArtist());
        existing.setAlbum(song.getAlbum());
        existing.setGenre(song.getGenre());
        existing.setDurationSeconds(song.getDurationSeconds());
        existing.setAudioPath(song.getAudioPath());
        existing.setCoverPath(song.getCoverPath());

        return songRepository.save(existing);
    }

    @Override
    public void deleteSong(Long id) {
        if (!songRepository.existsById(id)) {
            throw new RuntimeException("Song not found: " + id);
        }
        songRepository.deleteById(id);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return songRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Song> searchByArtist(String artist) {
        return songRepository.findByArtistContainingIgnoreCase(artist);
    }

    @Override
    public List<Song> searchByGenre(String genre) {
        return songRepository.findByGenreIgnoreCase(genre);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return songRepository.findByAlbumContainingIgnoreCase(album);
    }
}