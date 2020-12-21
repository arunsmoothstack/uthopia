package com.ss.uthopia.user.service;

import com.ss.uthopia.user.dao.UserDao;
import com.ss.uthopia.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        return  userDao.findAll();
    }

    public Optional<User> findById(long id) {
        return userDao.findById(id);
    }

    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public boolean userExists(long userId) {
        return userDao.existsById(userId);
    }

    public User findUserById(Long id) {
        return userDao.findById(id).get();
    }
}
