package com.events.gestion.application.service;

import com.events.gestion.application.dto.EventoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<EventoDto> getAllEvents();
    Optional<EventoDto> getEventById(Long eventId);
    EventoDto saveEvent(EventoDto eventoDto);
    Optional<EventoDto> updateEvent(Long eventId, EventoDto eventoDto);
    void deleteEvent(Long eventId);
    Page<EventoDto> getEventsByCriteria(Pageable pageable, String filter);
}
