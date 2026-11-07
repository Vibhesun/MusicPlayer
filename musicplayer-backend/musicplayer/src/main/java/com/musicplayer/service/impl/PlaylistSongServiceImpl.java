package com.musicplayer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.musicplayer.entity.PlaylistSong;
import com.musicplayer.repository.PlaylistSongRepository;
import com.musicplayer.service.PlaylistSongService;

@Service
public class PlaylistSongServiceImpl implements PlaylistSongService {

    private final PlaylistSongRepository repository;

    public PlaylistSongServiceImpl(PlaylistSongRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlaylistSong addSongToPlaylist(PlaylistSong playlistSong) {
        return repository.save(playlistSong);
    }

    @Override
    public List<PlaylistSong> getSongsByPlaylistId(Long playlistId) {
        return repository.findByPlaylistIdOrderByPositionAsc(playlistId);
    }

    @Override
    public PlaylistSong updatePlaylistSong(Long id, PlaylistSong playlistSong) {
        PlaylistSong existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Playlist song not found: " + id));

        existing.setPlaylist(playlistSong.getPlaylist());
        existing.setSong(playlistSong.getSong());
        existing.setPosition(playlistSong.getPosition());

        return repository.save(existing);
    }

    @Override
    public void removeSongFromPlaylist(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Playlist song not found: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public boolean songExistsInPlaylist(Long playlistId, Long songId) {
        return repository.existsByPlaylistIdAndSongId(playlistId, songId);
    }
}