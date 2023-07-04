package com.homedecor.rest.repo;

import com.homedecor.rest.entity.User;

import java.util.List;

public interface UserDao {
    User findByUserId(Long userId);
    List<User> findAllUsers();

    boolean existsById(Long userId);

    void save(User user);

    void deleteById(Long userId);
}
