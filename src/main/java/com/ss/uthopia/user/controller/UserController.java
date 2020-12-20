package com.ss.uthopia.user.controller;

import com.ss.uthopia.user.entity.User;
import com.ss.uthopia.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;
//    UserController(UserService userService) {
//        this.USERS_SERVICE = userService;
//    }

//    @GetMapping("api/users/all")
//    public ResponseEntity<List<User>> findAll() {
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.findAll());
//    }

    @GetMapping("api/users/all")
    public ResponseEntity<List<User>> findById() {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.findAll());
    }

    @GetMapping("api/users/byid/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        Optional<User> users= userService.findById(id);
        if(!users.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(users.get());
    }

    @DeleteMapping("api/users/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
