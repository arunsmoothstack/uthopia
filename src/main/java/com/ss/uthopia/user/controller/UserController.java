package com.ss.uthopia.user.controller;

import com.ss.uthopia.user.entity.User;
import com.ss.uthopia.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService USERS_SERVICE;
    UserController(UserService userService) {
        this.USERS_SERVICE = userService;
    }

    @GetMapping("/all")
    public List<User> findUsers() {
        return USERS_SERVICE.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        Optional<User> users= USERS_SERVICE.findById(id);
        if(!users.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(users.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable long id) {
        USERS_SERVICE.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return USERS_SERVICE.createUser(user);
    }

}
