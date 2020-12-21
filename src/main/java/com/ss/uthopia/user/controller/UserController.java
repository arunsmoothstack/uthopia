package com.ss.uthopia.user.controller;

import com.ss.uthopia.user.entity.Booking;
import com.ss.uthopia.user.entity.User;
import com.ss.uthopia.user.service.BookingService;
import com.ss.uthopia.user.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService USER_SERVICE;
    private final BookingService BOOKING_SERVICE;

    UserController(UserService userService, BookingService bookingService) {
        USER_SERVICE = userService;
        BOOKING_SERVICE = bookingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findById(@RequestParam(value = "name", required = false) String name,
                                               @RequestParam(value = "username", required = false) String username,
                                               @RequestParam(value = "userId", required = false) Long userId) {
        List<User> users;
        if (userId != null) {
            Optional<User> userOptional = USER_SERVICE.findById(userId);
            users = userOptional.isPresent() ? new ArrayList<>(Arrays.asList(userOptional.get())) : null;
        } else if (username != null && name != null) {
            users = USER_SERVICE.findByNameAndUsername(name, username);
        } else if (username != null)
            users = USER_SERVICE.findByUsername(username);
        else if (name != null)
            users = USER_SERVICE.findByName(name);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        Optional<User> users= USER_SERVICE.findById(id);
        if(!users.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(users.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            USER_SERVICE.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not delete user with id: " + id + "\n" + e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("User with id: " + id.toString() + " deleted successfully");
    }

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User users) {
        return ResponseEntity.status(HttpStatus.CREATED).body(USER_SERVICE.saveUser(users));
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User users) {
        if(USER_SERVICE.userExists(users.getUserId()))
            return ResponseEntity.status(HttpStatus.OK).body(USER_SERVICE.saveUser(users));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<Booking> getBookings(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(BOOKING_SERVICE.findById(id).get());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
