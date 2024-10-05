package org.clubhive.repositories.jpa;

import org.clubhive.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByUserId(String userId);
}
