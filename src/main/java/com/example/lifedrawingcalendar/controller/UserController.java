package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.dto.EventRecord;
import com.example.lifedrawingcalendar.dto.UserRecord;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<UserRecord> addUser(@RequestParam String first, @RequestParam String last) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        userRepository.save(user);
        return ResponseEntity.ok(new UserRecord(
                user.getUserId(),
                user.getFirstName(),
                null,
                null
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecord> getUserByUserId(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new UserRecord(
                user.getUserId(),
                user.getFirstName(),
                user.getOrganizedEvents().stream()
                    .map(e -> new EventRecord(e.getEventId(), e.getEventName(), e.getEventLocation(), e.getEventDate(), e.getOrganizer().getUserId(), e.getModel().getUserId()))
                    .toList(),
                user.getModeledEvents().stream()
                    .map(e -> new EventRecord(e.getEventId(), e.getEventName(), e.getEventLocation(), e.getEventDate(), e.getOrganizer().getUserId(), user.getUserId()))
                    .toList()
        ));
    }

}
