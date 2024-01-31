package com.example.project_web_app.repo;

import com.example.project_web_app.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByTown(String town);

    List<Event> findByTown(String town);
}
