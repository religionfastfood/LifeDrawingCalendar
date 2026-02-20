package com.example.lifedrawingcalendar.repository;

import com.example.lifedrawingcalendar.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository <Event, Long> {
}
