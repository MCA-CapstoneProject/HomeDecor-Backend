package com.homedecor.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homedecor.rest.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserId(Long userId);
	Optional<User> findByEmail(String email);
	Optional<User> findByUsernameOrEmail(String username, String email);
	Optional<User> findByUsername(String username);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
}
