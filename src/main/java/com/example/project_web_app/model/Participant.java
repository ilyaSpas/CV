package com.example.project_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Введите ваше имя")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Введите вашу фамилию")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Введите ваше Отчество")
    @Column(name = "patronymic")
    private String patronymic;

    @NotEmpty(message = "Введите ваше номер телефона")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty(message = "Введите вашу дату рождения")
    @Column(name = "birthday")
    private String birthday;

    @NotEmpty(message = "Введите вашу почту")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Введите название Вашей аптеки")
    @Column(name = "pharmacy")
    private String pharmacy;

    @Column(name = "position")
    private String position;

    @NotEmpty(message = "Введите адрес аптеки")
    @Column(name = "pharmacy_address")
    private String pharmacyAddress;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @Column(name = "time_of_registration")
    private LocalDateTime timeOfRegistration;

    @PrePersist
    private void init(){
        timeOfRegistration = LocalDateTime.now();
    }
}
