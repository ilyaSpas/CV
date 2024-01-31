package com.example.project_web_app.repo;

import com.example.project_web_app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String username);
}
