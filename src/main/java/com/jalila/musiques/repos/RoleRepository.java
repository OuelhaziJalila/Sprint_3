package com.jalila.musiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalila.musiques.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}