package com.musicplayer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.musicplayer.entity.Favorite;
import com.musicplayer.service.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(
            @RequestBody Favorite favorite) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(favoriteService.addFavorite(favorite));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getFavoritesByUserId(
            @PathVariable Long userId) {
        return ResponseEntity.ok(
                favoriteService.getFavoritesByUserId(userId));
    }

    @GetMapping("/user/{userId}/song/{songId}")
    public ResponseEntity<Boolean> isFavorite(
            @PathVariable Long userId,
            @PathVariable Long songId) {
        return ResponseEntity.ok(
                favoriteService.isFavorite(userId, songId));
    }

    @DeleteMapping("/user/{userId}/song/{songId}")
    public ResponseEntity<Void> removeFavorite(
            @PathVariable Long userId,
            @PathVariable Long songId) {
        favoriteService.removeFavorite(userId, songId);
        return ResponseEntity.noContent().build();
    }
}