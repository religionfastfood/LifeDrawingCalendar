package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.dto.EventSummaryDTO;
import com.example.lifedrawingcalendar.dto.UserDTO;
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
    public ResponseEntity<UserDTO> addUser(@RequestParam String first, @RequestParam String last) {
        User user = new User();
        user.setFirstName(first);
        user.setLastName(last);
        userRepository.save(user);
        return ResponseEntity.ok(new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                null,
                null
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByUserId(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getOrganizedEvents().stream()
                    .map(e -> new EventSummaryDTO(e.getEventId(), e.getEventName(), user.getUserId(), e.getModel().getUserId()))
                    .toList(),
                user.getModeledEvents().stream()
                    .map(e -> new EventSummaryDTO(e.getEventId(), e.getEventName(), e.getOrganizer().getUserId(), user.getUserId()))
                    .toList()
        ));
    }

}
