package com.example.lifedrawingcalendar.dto;

import java.util.List;

public record UserDTO(
        Long id,
        String name,
        List<EventSummaryDTO> organizedEvents,
        List<EventSummaryDTO> modeledEvents
) { }
