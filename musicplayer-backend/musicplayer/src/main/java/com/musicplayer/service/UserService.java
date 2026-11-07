package com.musicplayer.service;

import java.util.List;
import java.util.Optional;
import com.musicplayer.entity.User;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
}