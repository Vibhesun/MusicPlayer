package com.musicplayer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.musicplayer.entity.Song;
import com.musicplayer.service.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(songService.saveSong(song));
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return songService.getSongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(
            @PathVariable Long id,
            @RequestBody Song song) {
        return ResponseEntity.ok(songService.updateSong(id, song));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<Song>> searchByTitle(
            @RequestParam String title) {
        return ResponseEntity.ok(songService.searchByTitle(title));
    }

    @GetMapping("/search/artist")
    public ResponseEntity<List<Song>> searchByArtist(
            @RequestParam String artist) {
        return ResponseEntity.ok(songService.searchByArtist(artist));
    }

    @GetMapping("/search/genre")
    public ResponseEntity<List<Song>> searchByGenre(
            @RequestParam String genre) {
        return ResponseEntity.ok(songService.searchByGenre(genre));
    }

    @GetMapping("/search/album")
    public ResponseEntity<List<Song>> searchByAlbum(
            @RequestParam String album) {
        return ResponseEntity.ok(songService.searchByAlbum(album));
    }
}