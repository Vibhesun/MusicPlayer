package com.musicplayer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow CORS for all endpoints including audio uploads and static files
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:3000",
                                "http://localhost:5173"
                        )
                        .allowedMethods(
                                "GET", "POST", "PUT", "DELETE", "OPTIONS"
                        )
                        .allowedHeaders("*");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // Allow browsers to stream / play MP3 and cover image files from the uploads directory
                registry.addResourceHandler("/uploads/**")
                        .addResourceLocations("file:uploads/", "file:./uploads/");
            }
        };
    }
}