package com.jalila.musiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalila.musiques.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}