package com.musicplayer.service;

import java.util.List;
import java.util.Optional;
import com.musicplayer.entity.Playlist;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    List<Playlist> getAllPlaylists();
    Optional<Playlist> getPlaylistById(Long id);
    List<Playlist> getPlaylistsByUserId(Long userId);
    Playlist updatePlaylist(Long id, Playlist playlist);
    void deletePlaylist(Long id);
}