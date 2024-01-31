package com.example.project_web_app.validator;

import com.example.project_web_app.model.Event;
import com.example.project_web_app.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventValidator implements Validator {

    private final EventService eventService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Event.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Event event = (Event) target;
        List<Event> eventsByTown = eventService.findAllByTown(event.getTown());
        List<Event> events = eventsByTown.stream()
                .filter(event1 -> event1.getDate().equals(event.getDate())).toList();

        if (!events.isEmpty()){
            errors.rejectValue("town", "", "Данное мероприятие уже созданно!");
        }
    }
}
