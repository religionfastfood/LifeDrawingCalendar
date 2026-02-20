package com.example.lifedrawingcalendar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String eventName;

    private String eventLocation;

    private LocalDateTime eventDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "model_id")
    private User model;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public User getModel() {
        return model;
    }

    public void setModel(User eventModel) {
        this.model = eventModel;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User eventOrganizer) {
        this.organizer = eventOrganizer;
    }



}
