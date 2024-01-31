package com.example.project_web_app.validator;

import com.example.project_web_app.models.Person;
import com.example.project_web_app.security.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonValidator implements Validator {
    private final PersonDetailsService personDetailsService;
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personDetailsService.loadUserByUsername(person.getEmail()) != null){
            errors.rejectValue("email", "", "Пользователь с такой " +
                                            "почтой уже зарегистрирован!");
        }
    }
}
