package com.example.project_web_app.controller;

import com.example.project_web_app.model.Participant;
import com.example.project_web_app.model.Position;
import com.example.project_web_app.service.EventService;
import com.example.project_web_app.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/events")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @Autowired
    private EventService eventService;

    @GetMapping("/{id}/registration")
    public String registrationForm(@ModelAttribute("participant") Participant participant,
                                   @PathVariable("id") Long id, Model model) {
        model.addAttribute("positions", Arrays.asList(Position.values()));
        return "participant/registrationPage";
    }

    @PostMapping("/{event_id}/registration")
    public String registration(@ModelAttribute("participant") Participant participant,
                               @PathVariable("event_id") Long eventId){
        participantService.save(participant, eventId);
        return "redirect:/";
    }

    @GetMapping("/{event_id}/report")
    public String report(@ModelAttribute("participant") Participant participant,
                         @PathVariable("event_id") Long eventId,
                         Model model){
        model.addAttribute("participants", eventService.findById(eventId).get().getParticipants());
        return "participant/reportPage";
    }

    @GetMapping("/{event_id}/qr")
    public String getQrCode(@PathVariable("event_id") Long eventId, Model model){
        model.addAttribute("id", eventId);
        return "participant/QRcodePage";
    }

    @PostMapping("/{event_id}/participant/{participant_id}/delete")
    public String deleteParticipant(@PathVariable("participant_id") Long id){
        participantService.delete(id);
        return "redirect:/events/{event_id}/report";
    }
}
