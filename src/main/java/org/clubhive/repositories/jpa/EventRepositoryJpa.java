package org.clubhive.repositories.jpa;


import org.clubhive.entities.EventEntity;
import org.clubhive.entities.OrganizerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepositoryJpa extends CrudRepository<EventEntity, Long>{
    EventEntity findByNameAndOrgnzId(String name, OrganizerEntity organizer);

    @Query(value = "SELECT * FROM events WHERE (desc_event REGEXP CONCAT('.*\\\\b(', ?1, ')\\\\b.*') OR name_event REGEXP CONCAT('.*\\\\b(', ?1, ')\\\\b.*') OR id_city IN (SELECT c.id_city FROM cities c,events e where e.id_city = c.id_city and c.name_city REGEXP CONCAT('.*\\\\b(', ?1, ')\\\\b.*'))  OR id_orgnz IN (SELECT o.id FROM organizers o, events e WHERE e.id_orgnz = o.id AND o.name_orgnz REGEXP CONCAT('.*\\\\b(', ?1, ')\\\\b.*'))) and date_event >= current_date and state_event = true", nativeQuery = true)
    List<EventEntity> filterEvents(String search);

    @Query(value="select e  from EventEntity e where e.id = ?1 and e.orgnzId.organizerId = ?2")
    EventEntity findByIdAndAndOrgnzId(Long id, String subject);

    @Query("select e from EventEntity e where e.orgnzId.organizerId = ?1")
    List<EventEntity> findAllByOrgnzId(String id);
}