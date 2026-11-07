package com.musicplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicplayer.entity.PlaylistSong;

@Repository
public interface PlaylistSongRepository
        extends JpaRepository<PlaylistSong, Long> {

    List<PlaylistSong> findByPlaylistIdOrderByPositionAsc(Long playlistId);

    boolean existsByPlaylistIdAndSongId(Long playlistId, Long songId);
}