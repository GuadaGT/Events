package com.events.gestion.application.service.impl;

import com.events.gestion.application.dto.EventoDto;
import com.events.gestion.application.mapper.EventoMapper;
import com.events.gestion.application.service.EventoService;
import com.events.gestion.domain.entity.Evento;
import com.events.gestion.domain.persistence.EventoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoPersistence persistence;
    private final EventoMapper mapper;

    @Autowired
    public EventoServiceImpl(EventoPersistence persistence, EventoMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<EventoDto> getAllEvents() {
       List<Evento> eventos = this.persistence.getAllEventos();
       return mapper.toDto(eventos);
    }

    @Override
    public Optional<EventoDto> getEventById(Long eventId) {
        return this.persistence.getEventoById(eventId).map(mapper::toDto);
    }

    @Override
    public EventoDto saveEvent(EventoDto eventoDto) {
        Evento evento = this.persistence.saveEvento(this.mapper.toEntity(eventoDto));
        return mapper.toDto(evento);
    }

    @Override
    public Optional<EventoDto> updateEvent(Long eventId, EventoDto eventoDto) {
        Optional<Evento> existingEventOptional = this.persistence.getEventoById(eventId);
        if (existingEventOptional.isPresent()){
            Evento existingEvento = existingEventOptional.get();
            if (eventoDto.getName() != null){
                existingEvento.setName(eventoDto.getName());
            } if (eventoDto.getDescription() != null){
                existingEvento.setDescription(eventoDto.getDescription());
            } if (eventoDto.getLocation() != null){
                existingEvento.setLocation(eventoDto.getLocation());
            } if (eventoDto.getDate() != null){
                existingEvento.setDate(eventoDto.getDate());
            }
            Evento evento = this.persistence.saveEvento(existingEvento);
            return Optional.of(mapper.toDto(evento));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteEvent(Long eventId) {
        this.persistence.deleteEvento(eventId);
    }

    @Override
    public Page<EventoDto> getEventsByCriteria(Pageable pageable, String filter) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name" );
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        Page<Evento> eventPage = this.persistence.findEventosByEvento(pageable,filter);
        return eventPage.map(mapper::toDto);
    }
}
