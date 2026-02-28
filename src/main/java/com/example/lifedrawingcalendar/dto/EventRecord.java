package com.example.lifedrawingcalendar.dto;

import java.time.LocalDateTime;

public record EventRecord(Long id, String eventName, String location, LocalDateTime eventDate, Long organizerId, Long modelId) { }
