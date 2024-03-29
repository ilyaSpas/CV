package com.example.project_web_app.service;

import com.example.project_web_app.model.Event;
import com.example.project_web_app.repo.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void create(Event event) {
        if (event.getHotelImageUrl().isEmpty()){
            event.setHotelImageUrl("https://images.divisare.com/images/c_limit,f_auto,h_2000,q_auto,w_3000/" +
                                   "v1490958815/kkofaeofhmpw57956lq6/morris-adjmi-architects-mark-mahaney-matthew-williams-" +
                                   "jimi-billingsley-wythe-hotel.jpg");
        }
        eventRepository.save(event);
    }

    public List<Event> findAllByTown(String town) {
        return eventRepository.findAllByTown(town);
    }

    public Page<Event> findWithPagination(Integer page, Integer bookPerPage) {
        return eventRepository.findAll(PageRequest.of(page, bookPerPage));
    }

    public List<Event> findByTown(String town) {
        return eventRepository.findByTown(town);
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public void update(Event event) {
        Event eventFromDB = eventRepository.findById(event.getId()).orElseThrow();
        eventFromDB.setTown(event.getTown());
        eventFromDB.setDate(event.getDate());
        eventFromDB.setHotel(event.getHotel());
        eventFromDB.setHotelAddress(event.getHotelAddress());
        eventFromDB.setConferenceHall(event.getConferenceHall());
        eventFromDB.setHotelImageUrl(event.getHotelImageUrl());
        eventRepository.save(eventFromDB);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

}
