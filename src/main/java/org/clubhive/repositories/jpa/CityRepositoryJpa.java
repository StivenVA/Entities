package org.clubhive.repositories.jpa;


import org.clubhive.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepositoryJpa extends JpaRepository<CityEntity, Long> {
    CityEntity findByName(String name);
}
