package com.example.lifedrawingcalendar.dto;

import java.util.List;

public record UserRecord(
        Long id,
        String name,
        List<EventRecord> organizedEvents,
        List<EventRecord> modeledEvents
) { }
