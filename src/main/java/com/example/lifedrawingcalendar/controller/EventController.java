package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.model.Event;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.EventRepository;
import com.example.lifedrawingcalendar.repository.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventController(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events/list";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute EventForm form, Model model) {
        Event newEvent = eventRepository.save()
    }

}
