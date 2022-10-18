package com.project.carrier.services;

import java.util.List;

import com.project.carrier.models.Role;
import com.project.carrier.models.User;


public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}