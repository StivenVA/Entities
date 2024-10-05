package org.clubhive.repositories.jpa;


import org.clubhive.entities.EventEntity;
import org.clubhive.entities.PromoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromoterRepositoryJpa extends JpaRepository<PromoterEntity, Long> {

    @Query("SELECT p FROM PromoterEntity p WHERE p.eventId = ?1")
    List<PromoterEntity> findByEvent(EventEntity event);

    @Query("SELECT p FROM PromoterEntity p WHERE p.code = ?1")
    PromoterEntity findByCode(String code);
}
