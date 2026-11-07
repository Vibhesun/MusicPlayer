package com.musicplayer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.musicplayer.entity.User;
import com.musicplayer.repository.UserRepository;
import com.musicplayer.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found: " + id));

        existing.setUsername(user.getUsername());
        existing.setEmail(user.getEmail());
        existing.setPasswordHash(user.getPasswordHash());
        existing.setRole(user.getRole());

        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}