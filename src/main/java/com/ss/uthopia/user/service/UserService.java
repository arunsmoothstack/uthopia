package com.ss.uthopia.user.service;

import com.ss.uthopia.user.dao.UserDao;
import com.ss.uthopia.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    public Optional<User> findById(long id) {
        return userDao.findById(id);
    }

    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    public User createUser(User user) {
        return userDao.save(user);
    }
}
