package com.ss.uthopia.user.dao;

import com.ss.uthopia.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

   // @Query("SELECT e from User e where (e.userId =:userId or :userId = 0) and (e.name=:name or :name = '') and (e.username=:username or :username = '') and (e.role=:role or :role = 0)")
    List<User> findAll();
    List<User> findByNameAndUsername(String name, String username);
    List<User> findByName(String name);
    List<User> findByUsername(String username);

}

