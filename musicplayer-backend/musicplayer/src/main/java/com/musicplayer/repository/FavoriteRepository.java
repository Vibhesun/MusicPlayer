package com.musicplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicplayer.entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUserId(Long userId);

    boolean existsByUserIdAndSongId(Long userId, Long songId);

    void deleteByUserIdAndSongId(Long userId, Long songId);
}