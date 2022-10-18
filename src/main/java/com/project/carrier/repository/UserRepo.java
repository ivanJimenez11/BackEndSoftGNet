package com.project.carrier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.carrier.models.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}

