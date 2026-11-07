package com.musicplayer.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileStorageConfig {

    @Value("${music.upload-dir:uploads}")
    private String uploadDir;

    @Bean
    public Path uploadPath() {
        Path path = Paths.get(uploadDir)
                .toAbsolutePath()
                .normalize();

        return path;
    }
}