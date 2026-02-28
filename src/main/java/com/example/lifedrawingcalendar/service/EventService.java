package com.example.lifedrawingcalendar.service;

import com.example.lifedrawingcalendar.dto.EventRecord;
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

    public Iterable<Event> list() {
        return eventRepository.findAll();
    }

    @Transactional
    public Event createEvent(EventRecord eventRecord) {

        Event event = new Event();
        event.setEventName(eventRecord.eventName());

        if (eventRecord.organizerId() != null) {
            User organizer = userRepository.getByUserId(eventRecord.organizerId());
            event.setOrganizer(organizer);
        }

        if (eventRecord.modelId() != null) {
            User model = userRepository.getByUserId(eventRecord.modelId());
            event.setModel(model);
        }

        return eventRepository.save(event);
    }
}
