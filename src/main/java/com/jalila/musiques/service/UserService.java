package com.jalila.musiques.service;

import com.jalila.musiques.entities.Role;
import com.jalila.musiques.entities.User;
import org.springframework.stereotype.Service;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}
