package com.musicplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicplayer.entity.ListeningHistory;

@Repository
public interface ListeningHistoryRepository
        extends JpaRepository<ListeningHistory, Long> {

    List<ListeningHistory> findByUserIdOrderByPlayedAtDesc(Long userId);
}