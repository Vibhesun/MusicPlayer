package com.musicplayer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.musicplayer.entity.Playlist;
import com.musicplayer.service.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(
            @RequestBody Playlist playlist) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(playlistService.createPlaylist(playlist));
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(
            @PathVariable Long id) {
        return playlistService.getPlaylistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByUserId(
            @PathVariable Long userId) {
        return ResponseEntity.ok(
                playlistService.getPlaylistsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(
            @PathVariable Long id,
            @RequestBody Playlist playlist) {
        return ResponseEntity.ok(
                playlistService.updatePlaylist(id, playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(
            @PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}