package com.homedecor.rest.repo;

import com.homedecor.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepo userRepo;

    @Override
    public User findByUserId(Long userId) {
        return userRepo.findByUserId(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public boolean existsById(Long userId) {
        return userRepo.existsById(userId);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);

    }

    @Override
    public void deleteById(Long userId) {
        userRepo.deleteById(userId);
    }
}
