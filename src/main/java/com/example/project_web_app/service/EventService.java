package com.example.project_web_app.service;

import com.example.project_web_app.models.Event;
import com.example.project_web_app.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event){
        eventRepository.save(event);
    }
}
