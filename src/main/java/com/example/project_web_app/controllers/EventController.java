package com.example.project_web_app.controllers;

import com.example.project_web_app.models.Event;
import com.example.project_web_app.service.EventService;
import com.example.project_web_app.validator.EventValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final EventValidator eventValidator;

    @GetMapping
    public String allEvents(Model model,
                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                            @RequestParam(value = "event_per_page", required = false, defaultValue = "3") Integer bookPerPage) {
        Page<Event> events = eventService.findWithPagination(page, bookPerPage);
        model.addAttribute("events", events);
        model.addAttribute("numbers", IntStream.range(0, events.getTotalPages()).toArray());
        return "event/eventsPage";
    }

    @GetMapping("/search")
    public String search(@Param("name") String town, Model model) {
        model.addAttribute("find_events", eventService.findByTown(town));
        return "event/eventsPage";
    }

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

    @GetMapping("/{id}")
    public String showEvent(@PathVariable("id") Long id,
                            @ModelAttribute("event") Event event,
                            Model model) {
        model.addAttribute("event", eventService.findById(id));
        return "event/eventDetailsPage";
    }

    @GetMapping("/{id}/edit")
    public String editEvent(@ModelAttribute("event") Event event,
                            @PathVariable("id") Long id,
                            Model model) {
        model.addAttribute("event", eventService.findById(id));
        return "event/editEventPage";
    }

    @PostMapping("/{id}/update")
    public String updateEvent(@ModelAttribute("id") Long id,
                              @ModelAttribute("event") @Valid Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:/events/{id}";
        }
        eventService.update(event);
        return "redirect:/events/{id}";
    }

    @PostMapping("/{id}/delete")
    public String deleteEvent(@PathVariable("id") Long id) {
        eventService.delete(id);
        return "redirect:/events";
    }
}
