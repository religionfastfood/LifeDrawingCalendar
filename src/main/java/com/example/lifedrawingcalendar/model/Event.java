package com.example.lifedrawingcalendar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventName;

    private String eventLocation;

    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private User model;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

}
