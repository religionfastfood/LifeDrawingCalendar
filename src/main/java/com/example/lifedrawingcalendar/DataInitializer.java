package com.example.lifedrawingcalendar;

import com.example.lifedrawingcalendar.dto.EventRecord;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.UserRepository;
import com.example.lifedrawingcalendar.service.EventService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EventService eventService;
    private final UserRepository userRepository;

    public DataInitializer(EventService eventService, UserRepository userRepository) {
        this.eventService = eventService;
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Chris");
        user.setLastName("McDonald");
        userRepository.save(user);
        eventService.createEvent(new EventRecord(1L, "Dialog After Dark", "1001 N Central Ave", LocalDateTime.parse("2026-03-05T07:00:00"), 1L, 1L));
        eventService.createEvent(new EventRecord(1L, "Dialog After Dark", "1001 N Central Ave", LocalDateTime.parse("2026-03-19T07:00:00"), 1L, 1L));
        eventService.createEvent(new EventRecord(1L, "Dialog After Dark", "1001 N Central Ave", LocalDateTime.parse("2026-04-02T07:00:00"), 1L, 1L));

    }
}
