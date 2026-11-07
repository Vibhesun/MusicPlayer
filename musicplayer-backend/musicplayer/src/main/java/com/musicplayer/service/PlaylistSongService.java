package com.musicplayer.service;

import java.util.List;
import com.musicplayer.entity.PlaylistSong;

public interface PlaylistSongService {
    PlaylistSong addSongToPlaylist(PlaylistSong playlistSong);
    List<PlaylistSong> getSongsByPlaylistId(Long playlistId);
    PlaylistSong updatePlaylistSong(Long id, PlaylistSong playlistSong);
    void removeSongFromPlaylist(Long id);
    boolean songExistsInPlaylist(Long playlistId, Long songId);
}