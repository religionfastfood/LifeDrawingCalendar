package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestParam String first, @RequestParam String last) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Long id) {
        User user = userRepository.findUserByUserId(id);
        return ResponseEntity.ok(user);
    }

}
