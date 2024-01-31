package com.example.project_web_app.repo;

import com.example.project_web_app.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
