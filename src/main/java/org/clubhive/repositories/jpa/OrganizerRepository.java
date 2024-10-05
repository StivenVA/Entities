package org.clubhive.repositories.jpa;


import org.clubhive.entities.OrganizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Long> {

    OrganizerEntity findByOrganizerId(String organizerId);
    OrganizerEntity findById(long id);
    boolean existsByOrganizerId(String organizerId);
}
