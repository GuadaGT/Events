package com.events.gestion.application.dto;

import java.time.LocalDate;
import java.util.Objects;

public class EventoDto {

    private Long id;
    private String name;
    private String location;
    private String description;
    private LocalDate date;

    public EventoDto() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventoDto eventoDto = (EventoDto) o;
        return Objects.equals(id, eventoDto.id) && Objects.equals(name, eventoDto.name) && Objects.equals(location, eventoDto.location) && Objects.equals(description, eventoDto.description) && Objects.equals(date, eventoDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, description, date);
    }

    @Override
    public String toString() {
        return "eventDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
