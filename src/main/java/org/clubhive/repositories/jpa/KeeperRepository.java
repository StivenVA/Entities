package org.clubhive.repositories.jpa;


import org.clubhive.entities.OrganizerEntity;
import org.clubhive.entities.KeeperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeeperRepository extends JpaRepository<KeeperEntity,Long> {
    boolean existsByKeeperId(String organizerId);

    List<KeeperEntity> findAllByOrganizer(OrganizerEntity organizerEntity);

    KeeperEntity findByKeeperId(String keeperId);
}
