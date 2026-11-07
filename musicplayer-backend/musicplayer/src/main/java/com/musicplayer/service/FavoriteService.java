package com.musicplayer.service;

import java.util.List;
import com.musicplayer.entity.Favorite;

public interface FavoriteService {
    Favorite addFavorite(Favorite favorite);
    List<Favorite> getFavoritesByUserId(Long userId);
    boolean isFavorite(Long userId, Long songId);
    void removeFavorite(Long userId, Long songId);
}