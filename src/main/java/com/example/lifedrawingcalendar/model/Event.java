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
    private Long id;

    private String name;

    private String location;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private User model;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

}
