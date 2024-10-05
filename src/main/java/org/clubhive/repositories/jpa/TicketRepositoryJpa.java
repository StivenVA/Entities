package org.clubhive.repositories.jpa;


import org.clubhive.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepositoryJpa extends JpaRepository<TicketEntity,Long> {

    @Query("select t from TicketEntity t where t.eventId.id = ?1")
    List<TicketEntity> findAllByEventId(Long idEvent);
}
