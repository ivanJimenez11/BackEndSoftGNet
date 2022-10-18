package com.project.carrier.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.carrier.models.Role;
import com.project.carrier.models.User;
import com.project.carrier.repository.RoleRepo;
import com.project.carrier.repository.UserRepo;


@Service @Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder;
	
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		if (user == null) {
			logger.error("User not found in the DB");
			throw new UsernameNotFoundException("User not found in the DB");
		} else {
			logger.info("User found in the DB: {}", username);
			
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> { 
			authorities.add(new SimpleGrantedAuthority(role.getName()));	
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
	

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("Saving new user " + user.getName() + " to the database");
		//NEW
		System.out.println("here1");

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println("here2");
		System.out.println("user x: " + user);

		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		System.out.println("Saving new role " + role.getName() + "to the database");

		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		System.out.println("Adding role " + roleName + "to user " + username);

		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		System.out.println("Fetching user " + username);

		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		System.out.println("Fetching all users");

		return userRepo.findAll();
	}
	}
