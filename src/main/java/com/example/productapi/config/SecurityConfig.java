package com.example.productapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Allow Swagger UI and OpenAPI
                .anyRequest().authenticated() // All other requests require authentication
            )
            .httpBasic(); // Use Basic Authentication for testing
        return http.build();
    }
}
