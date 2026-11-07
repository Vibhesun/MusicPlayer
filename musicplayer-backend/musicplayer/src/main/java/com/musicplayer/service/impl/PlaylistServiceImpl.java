package com.musicplayer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.musicplayer.entity.Playlist;
import com.musicplayer.repository.PlaylistRepository;
import com.musicplayer.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public List<Playlist> getPlaylistsByUserId(Long userId) {
        return playlistRepository.findByUserId(userId);
    }

    @Override
    public Playlist updatePlaylist(Long id, Playlist playlist) {
        Playlist existing = playlistRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Playlist not found: " + id));

        existing.setName(playlist.getName());
        existing.setUser(playlist.getUser());

        return playlistRepository.save(existing);
    }

    @Override
    public void deletePlaylist(Long id) {
        if (!playlistRepository.existsById(id)) {
            throw new RuntimeException("Playlist not found: " + id);
        }
        playlistRepository.deleteById(id);
    }
}