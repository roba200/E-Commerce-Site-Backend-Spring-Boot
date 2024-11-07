package com.fullstack.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.e_commerce.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}