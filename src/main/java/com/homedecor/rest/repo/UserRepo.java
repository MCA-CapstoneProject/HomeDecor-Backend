package com.homedecor.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homedecor.rest.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserId(Long userId);

}
