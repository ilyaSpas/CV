package com.example.project_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Введите ваше имя")
    @Column(name = "firsName")
    private String firsName;

    @NotEmpty(message = "Введите вашу фамилию")
    @Column(name = "lastName")
    private String lastName;

    @NotEmpty(message = "Введите ваше отчетство")
    @Column(name = "patronymic")
    private String patronymic;

    @NotEmpty(message = "Введите дату рождения")
    @Column(name = "birthday")
    private String birthday;

    @NotEmpty(message = "Введите номер телефона")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty(message = "Введите вашу почту")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Введите ващ пароль")
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "date_of_registration")
    private LocalDateTime dateOfRegistration;

    @PrePersist
    private void init(){
        dateOfRegistration = LocalDateTime.now();
        role = Role.USER;
    }
}
