package com.musicplayer.service;

import java.util.List;
import com.musicplayer.entity.ListeningHistory;

public interface ListeningHistoryService {
    ListeningHistory recordListening(ListeningHistory history);
    List<ListeningHistory> getHistoryByUserId(Long userId);
    void deleteHistory(Long id);
    void clearHistoryByUserId(Long userId);
}