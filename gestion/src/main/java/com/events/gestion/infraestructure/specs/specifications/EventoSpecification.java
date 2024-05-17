package com.events.gestion.infraestructure.specs.specifications;

import com.events.gestion.domain.entity.Evento;
import com.events.gestion.infraestructure.specs.shared.EntitySpecification;
import com.events.gestion.infraestructure.specs.shared.SearchCriteria;
import com.events.gestion.infraestructure.specs.shared.SearchOperation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EventoSpecification extends EntitySpecification<Evento> implements Specification<Evento> {

    public EventoSpecification(List<SearchCriteria> searchCriteria) {
        this.criteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Evento> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : this.criteria) {
            if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
