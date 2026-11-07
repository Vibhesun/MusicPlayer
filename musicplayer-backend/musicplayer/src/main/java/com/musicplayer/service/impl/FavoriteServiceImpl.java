package com.musicplayer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.musicplayer.entity.Favorite;
import com.musicplayer.repository.FavoriteRepository;
import com.musicplayer.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository repository;

    public FavoriteServiceImpl(FavoriteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Favorite addFavorite(Favorite favorite) {
        Long userId = favorite.getUser().getId();
        Long songId = favorite.getSong().getId();

        if (repository.existsByUserIdAndSongId(userId, songId)) {
            throw new RuntimeException("Song is already in favorites");
        }

        return repository.save(favorite);
    }

    @Override
    public List<Favorite> getFavoritesByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public boolean isFavorite(Long userId, Long songId) {
        return repository.existsByUserIdAndSongId(userId, songId);
    }

    @Override
    public void removeFavorite(Long userId, Long songId) {
        if (!repository.existsByUserIdAndSongId(userId, songId)) {
            throw new RuntimeException("Favorite not found");
        }

        repository.deleteByUserIdAndSongId(userId, songId);
    }
}