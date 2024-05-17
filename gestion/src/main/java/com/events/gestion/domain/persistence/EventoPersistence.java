package com.events.gestion.domain.persistence;

import com.events.gestion.domain.entity.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventoPersistence {
    List<Evento> getAllEventos();
    Optional<Evento> getEventoById(Long eventId);
    Evento saveEvento(Evento evento);
    void deleteEvento(Long eventId);
    Page<Evento> findEventosByEvento(Pageable pageable, String filter);
}
