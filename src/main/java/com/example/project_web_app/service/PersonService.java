package com.example.project_web_app.service;

import com.example.project_web_app.models.Person;
import com.example.project_web_app.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void create(Person person){
        personRepository.save(person);
    }
}
