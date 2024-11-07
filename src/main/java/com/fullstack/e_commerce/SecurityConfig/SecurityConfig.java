package com.fullstack.e_commerce.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Enables method-level security (e.g., @PreAuthorize)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless applications
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/auth/register").permitAll() // Allow registration without authentication
                        .requestMatchers("/api/auth/login").permitAll() // Allow login without authentication
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Restrict access to admin endpoints
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions for JWT
                );

        return http.build();
    }
}