package com.example.project_web_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @NotEmpty(message = "Необходимо ввести название города проведения мероприятия!")
    @Column(name = "town")
    private String town;

    @NotEmpty(message = "Необходимо ввести дату проведения мероприятия!")
    @Column(name = "date")
    private String date;

    @NotEmpty(message = "Необходимо ввести название отеля!")
    @Column(name = "hotel")
    private String hotel;

    @Column(name = "image_url")
    private String hotelImageUrl;

    @NotEmpty(message = "Необходимо ввести адрес проведения мероприятия!")
    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "conference_hall")
    private String conferenceHall;
}
