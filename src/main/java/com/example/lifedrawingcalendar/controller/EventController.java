package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.model.Event;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.EventRepository;
import com.example.lifedrawingcalendar.repository.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EventController {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventController(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/event/add")
    public ResponseEntity<Event> addEvent(@RequestParam String eventName, @RequestParam String eventLocation, @RequestParam("eventDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventDateTime, @RequestParam Long eventOrganizer) {
        User user = userRepository.findUserByUserId(eventOrganizer);
        Event event = new Event();
        event.setEventName(eventName);
        event.setEventLocation(eventLocation);
        event.setEventDate(eventDateTime);
        event.setOrganizer(user);
        eventRepository.save(event);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/event/list")
    public ResponseEntity<Iterable<Event>> getEvents() {
        Iterable<Event> events =  eventRepository.findAll();
        return ResponseEntity.ok(events);
    }
}
