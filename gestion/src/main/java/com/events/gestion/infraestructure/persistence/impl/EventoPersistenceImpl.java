package com.events.gestion.infraestructure.persistence.impl;

import com.events.gestion.domain.entity.Evento;
import com.events.gestion.domain.persistence.EventoPersistence;
import com.events.gestion.infraestructure.persistence.EventoJpaRepository;
import com.events.gestion.infraestructure.specs.shared.SearchCriteriaHelper;
import com.events.gestion.infraestructure.specs.specifications.EventoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventoPersistenceImpl implements EventoPersistence {

    private final EventoJpaRepository eventoRepository;

    @Autowired
    public EventoPersistenceImpl(EventoJpaRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Evento> getAllEventos() {
        return this.eventoRepository.findAll();
    }

    @Override
    public Optional<Evento> getEventoById(Long id) {
        return this.eventoRepository.findById(id);
    }

    @Override
    public Evento saveEvento(Evento evento) {
       return this.eventoRepository.save(evento);
    }

    @Override
    public void deleteEvento(Long eventId) {
        this.eventoRepository.deleteById(eventId);
    }

    @Override
    public Page<Evento> findEventosByEvento(Pageable pageable, String filters) {
        EventoSpecification specification = new EventoSpecification(SearchCriteriaHelper.fromFilterString(filters));
        return this.eventoRepository.findAll(specification, pageable);
    }
}
