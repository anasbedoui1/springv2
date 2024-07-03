package com.example.travelreservation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/api/**") // Map all API routes
               .allowedOrigins("http://localhost:4200", "http://localhost:8083") // Allowed origins
               .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed methods
               .allowedHeaders("*") // Allowed headers
               .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Methods", "Access-Control-Allow-Headers")
               .allowCredentials(true); // Allow credentials if needed
    }
    
}

