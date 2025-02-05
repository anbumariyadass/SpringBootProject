package com.simple.simplewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simple.simplewebapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {	
	User findByUsername(String username);
}
