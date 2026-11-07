package com.musicplayer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.musicplayer.entity.PlaylistSong;
import com.musicplayer.service.PlaylistSongService;

@RestController
@RequestMapping("/api/playlist-songs")
public class PlaylistSongController {

    private final PlaylistSongService playlistSongService;

    public PlaylistSongController(
            PlaylistSongService playlistSongService) {
        this.playlistSongService = playlistSongService;
    }

    @PostMapping
    public ResponseEntity<PlaylistSong> addSongToPlaylist(
            @RequestBody PlaylistSong playlistSong) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(playlistSongService.addSongToPlaylist(playlistSong));
    }

    @GetMapping("/playlist/{playlistId}")
    public ResponseEntity<List<PlaylistSong>> getSongsByPlaylistId(
            @PathVariable Long playlistId) {
        return ResponseEntity.ok(
                playlistSongService.getSongsByPlaylistId(playlistId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistSong> updatePlaylistSong(
            @PathVariable Long id,
            @RequestBody PlaylistSong playlistSong) {
        return ResponseEntity.ok(
                playlistSongService.updatePlaylistSong(id, playlistSong));
    }

    @GetMapping("/playlist/{playlistId}/song/{songId}")
    public ResponseEntity<Boolean> checkSongInPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long songId) {
        return ResponseEntity.ok(
                playlistSongService.songExistsInPlaylist(
                        playlistId, songId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeSongFromPlaylist(
            @PathVariable Long id) {
        playlistSongService.removeSongFromPlaylist(id);
        return ResponseEntity.noContent().build();
    }
}