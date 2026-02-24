package com.example.lifedrawingcalendar.dto;

public record EventSummaryDTO(
        Long id,
        String title,
        Long organizerId,
        Long modelId
) {
}
