package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestParam String first, @RequestParam String last, @RequestParam String gender,
                                        @RequestParam String profilePicturePath) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        user.setGender(gender);
        user.setProfilePicturePath(profilePicturePath);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userRepository.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Long id) {
        User user = userRepository.findUserByUserId(id);
        return ResponseEntity.ok(user);
    }

}
