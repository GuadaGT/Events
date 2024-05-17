package com.events.gestion.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventSequence")
    private Long id;

    @Column(name = "Name", length = 30, nullable = false)
    private String name;

    @Column(name = "Location", length = 100, nullable = false)
    private String location;

    @Column(name = "Description", length = 100, nullable = false)
    private String description;

    @Column(name = "Date",  nullable = false)
    private LocalDate date;

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
