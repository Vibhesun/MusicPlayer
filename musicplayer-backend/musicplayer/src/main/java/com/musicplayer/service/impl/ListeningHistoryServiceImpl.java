package com.musicplayer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.musicplayer.entity.ListeningHistory;
import com.musicplayer.repository.ListeningHistoryRepository;
import com.musicplayer.service.ListeningHistoryService;

@Service
public class ListeningHistoryServiceImpl implements ListeningHistoryService {

    private final ListeningHistoryRepository repository;

    public ListeningHistoryServiceImpl(
            ListeningHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ListeningHistory recordListening(ListeningHistory history) {
        return repository.save(history);
    }

    @Override
    public List<ListeningHistory> getHistoryByUserId(Long userId) {
        return repository.findByUserIdOrderByPlayedAtDesc(userId);
    }

    @Override
    public void deleteHistory(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Listening history not found: " + id);
        }

        repository.deleteById(id);
    }

    @Override
    public void clearHistoryByUserId(Long userId) {
        List<ListeningHistory> history =
                repository.findByUserIdOrderByPlayedAtDesc(userId);

        repository.deleteAll(history);
    }
}