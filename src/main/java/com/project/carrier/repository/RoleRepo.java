package com.project.carrier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.carrier.models.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Role findByName(String name);
}
