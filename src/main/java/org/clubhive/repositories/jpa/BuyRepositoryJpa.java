package org.clubhive.repositories.jpa;

import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyRepositoryJpa extends JpaRepository<BuyEntity,Long> {
    List<BuyEntity> findByOwner(UserEntity owner);
}
