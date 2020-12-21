package com.ss.uthopia.user.controller;

import com.ss.uthopia.user.entity.Booking;
import com.ss.uthopia.user.entity.User;
import com.ss.uthopia.user.service.BookingService;
import com.ss.uthopia.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<User>> findById() {
        return ResponseEntity.status(HttpStatus.OK).body(USER_SERVICE.findAll());
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
    public ResponseEntity<Long> deleteUser(@PathVariable long id) {
        USER_SERVICE.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(USER_SERVICE.saveUser(user));
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if(USER_SERVICE.userExists(user.getUserId()))
            return ResponseEntity.status(HttpStatus.CREATED).body(USER_SERVICE.saveUser(user));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/{id}/bookings")
    public Booking getBookings(@PathVariable long id) {

        return BOOKING_SERVICE.findById(id).get();
    }

}
