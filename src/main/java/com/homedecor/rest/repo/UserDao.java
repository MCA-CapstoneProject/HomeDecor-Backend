package com.homedecor.rest.repo;

import com.homedecor.rest.entity.User;

import java.util.List;

public interface UserDao {
    User findByUserId(Long userId);
    List<User> findAllUsers();

    boolean existsById(Long userId);

    void save(User user);

    void deleteById(Long userId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByUserNameOrEmail(String userName, String email);

//    Optional<User> findByEmail(String email);
//    Optional<User> findByUsernameOrEmail(String username, String email);
//    Optional<User> findByUsername(String username);
//    boolean existsByUsername(String username);
//    boolean existsByEmail(String email);
}
