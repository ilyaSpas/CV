package com.example.project_web_app.repo;

import com.example.project_web_app.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
