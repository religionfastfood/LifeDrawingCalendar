package com.example.lifedrawingcalendar.controller;

import com.example.lifedrawingcalendar.dto.EventRecord;
import com.example.lifedrawingcalendar.model.Event;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.EventRepository;
import com.example.lifedrawingcalendar.repository.UserRepository;
import com.example.lifedrawingcalendar.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService, UserRepository userRepository) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("events", eventService.list());
        return "index";
    }

    @PostMapping("/create")
    public String save(@RequestBody EventRecord eventRecord, Model model) {
        Event event = eventService.createEvent(eventRecord);
        model.addAttribute("event", event);
        return "new-event-row :: row";
    }

}
