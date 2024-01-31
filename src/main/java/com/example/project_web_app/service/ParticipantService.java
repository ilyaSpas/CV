package com.example.project_web_app.service;

import com.example.project_web_app.model.Event;
import com.example.project_web_app.model.Participant;
import com.example.project_web_app.repo.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EventService eventService;

    public void save(Participant participant, Long eventId){
        Event event = eventService.findById(eventId).get();
        participant.setEvent(event);
        participantRepository.save(participant);
    }

    public List<Participant> findByEventId(Long eventId) {
        return participantRepository.findByEventId(eventId);
    }

    public void delete(Long id) {
        participantRepository.deleteById(id);
    }
}
