package com.ss.uthopia.user.service;

import com.ss.uthopia.user.dao.UserDao;
import com.ss.uthopia.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

//    public UserService() {
//        //this.userDao = userDao;
//    }


    public Iterable<User> findAll() {
        return  userDao.findAll();
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
