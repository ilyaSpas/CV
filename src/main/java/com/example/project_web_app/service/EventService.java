package com.example.project_web_app.service;

import com.example.project_web_app.models.Event;
import com.example.project_web_app.repo.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void create(Event event) {
        eventRepository.save(event);
    }

    public List<Event> findAllByTown(String town) {
        return eventRepository.findAllByTown(town);
    }

    public List<Event> findAllByDate(String date){
        return eventRepository.findAllByDate(date);
    }
}
