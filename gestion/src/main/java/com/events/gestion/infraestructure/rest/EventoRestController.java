package com.events.gestion.infraestructure.rest;

import com.events.gestion.application.dto.EventoDto;
import com.events.gestion.application.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventoRestController {

    private final EventoService eventoService;

    @Autowired
    public EventoRestController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping(value = "/events-all", produces = "application/json")
    ResponseEntity<List<EventoDto>> getAllEvents() {
        List<EventoDto> users = this.eventoService.getAllEvents();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/events", produces = "application/json")
    public ResponseEntity<Page<EventoDto>> getEventsByCriteriaPaged(@RequestParam(value = "filter", required = false) String filter, Pageable pageable) {
        Page<EventoDto> events = this.eventoService.getEventsByCriteria(pageable, filter);
        return new ResponseEntity<Page<EventoDto>>(events, HttpStatus.OK);
    }

    @GetMapping(value = "/events/{eventId}")
    ResponseEntity<EventoDto> getEventById(@PathVariable Long eventId) {
        Optional<EventoDto> event = this.eventoService.getEventById(eventId);
        if (event.isPresent()) {
            return new ResponseEntity<>(event.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/events", produces = "application/json", consumes = "application/json")
    ResponseEntity<EventoDto> insertEvent(@RequestBody EventoDto eventoDto) {
        EventoDto eventSaved = this.eventoService.saveEvent(eventoDto);
        return new ResponseEntity<>(eventSaved, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/events/{eventId}", produces = "application/json", consumes = "application/json")
    ResponseEntity<EventoDto> updateEvent(@PathVariable Long eventId, @RequestBody EventoDto eventoDto) {
        Optional<EventoDto> uventUpdate = this.eventoService.updateEvent(eventId, eventoDto);
        if (uventUpdate.isPresent()) {
            return new ResponseEntity<>(uventUpdate.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/events/{eventId}")
    ResponseEntity<?> deleteEventById(@PathVariable Long eventId) {
        this.eventoService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
