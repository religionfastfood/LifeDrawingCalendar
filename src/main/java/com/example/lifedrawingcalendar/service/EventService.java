package com.example.lifedrawingcalendar.service;

import com.example.lifedrawingcalendar.form.EventForm;
import com.example.lifedrawingcalendar.model.Event;
import com.example.lifedrawingcalendar.model.User;
import com.example.lifedrawingcalendar.repository.EventRepository;
import com.example.lifedrawingcalendar.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Event createEvent(EventForm form) {

        Event event = new Event();
        event.setEventName(form.getEventName());

        if (form.getOrganizerId() != null) {
            User organizer = userRepository.getByUserId(form.getOrganizerId());
            event.setOrganizer(organizer);
        }

        if (form.getModelId() != null) {
            User model = userRepository.getByUserId(form.getModelId());
            event.setModel(model);
        }

        return eventRepository.save(event);
    }
}
