package com.example.project_web_app.controllers;

import com.example.project_web_app.models.Event;
import com.example.project_web_app.service.EventService;
import com.example.project_web_app.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final EventValidator eventValidator;

    @GetMapping("/new")
    public String createEventPage(@ModelAttribute("event")Event event) {
        return "event/createEventPage";
    }

    @PostMapping("/new")
    public String createEvent(@ModelAttribute("event") @Valid Event event, BindingResult bindingResult) {
        eventValidator.validate(event, bindingResult);
        if (bindingResult.hasErrors()){
            return "event/createEventPage";
        }
        eventService.create(event);
        return "redirect:/";
    }
}
