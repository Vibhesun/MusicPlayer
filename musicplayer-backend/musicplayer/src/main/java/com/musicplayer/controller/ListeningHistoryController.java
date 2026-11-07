package com.musicplayer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.musicplayer.entity.ListeningHistory;
import com.musicplayer.service.ListeningHistoryService;

@RestController
@RequestMapping("/api/listening-history")
public class ListeningHistoryController {

    private final ListeningHistoryService historyService;

    public ListeningHistoryController(
            ListeningHistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public ResponseEntity<ListeningHistory> recordListening(
            @RequestBody ListeningHistory history) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(historyService.recordListening(history));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ListeningHistory>> getHistoryByUserId(
            @PathVariable Long userId) {
        return ResponseEntity.ok(
                historyService.getHistoryByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(
            @PathVariable Long id) {
        historyService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> clearHistoryByUserId(
            @PathVariable Long userId) {
        historyService.clearHistoryByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}