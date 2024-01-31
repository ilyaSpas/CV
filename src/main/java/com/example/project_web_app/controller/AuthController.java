package com.example.project_web_app.controller;

import com.example.project_web_app.model.Person;
import com.example.project_web_app.service.PersonService;
import com.example.project_web_app.validator.PersonValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final PersonService personService;
    private final PersonValidator personValidator;

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")Person person){
        return "auth/registrationPage";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()){
            return "auth/registrationPage";
        }
        personService.create(person);
        return "redirect:/";
    }

    @GetMapping("/auth")
    public String authorizationPage(){
        return "auth/authorizationPage";
    }
}
