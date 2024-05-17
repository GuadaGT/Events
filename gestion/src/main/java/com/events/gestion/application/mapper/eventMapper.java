package com.events.gestion.application.mapper;

import com.events.gestion.application.dto.EventoDto;
import com.events.gestion.domain.entity.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface eventMapper extends EntityMapper<EventoDto, Evento> {

    default Evento fromId(Long id) {
        if (id == null) return null;
        Evento evento = new Evento();
        evento.setId(id);
        return evento;
    }
}
