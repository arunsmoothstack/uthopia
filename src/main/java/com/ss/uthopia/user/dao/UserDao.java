package com.ss.uthopia.user.dao;

import com.ss.uthopia.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    List<User> findAll();
}

