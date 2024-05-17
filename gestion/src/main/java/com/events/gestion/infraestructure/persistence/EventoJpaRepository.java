package com.events.gestion.infraestructure.persistence;

import com.events.gestion.domain.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventoJpaRepository extends JpaRepository<Evento, Long> , JpaSpecificationExecutor<Evento> {
}
