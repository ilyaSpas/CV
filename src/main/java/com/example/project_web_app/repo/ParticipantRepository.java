package com.example.project_web_app.repo;

import com.example.project_web_app.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByEventId(Long eventId);
}
