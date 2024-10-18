package org.clubhive.repositories.jpa;

import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyRepositoryJpa extends JpaRepository<BuyEntity,Long> {

    @Query(value = "select bt.* from buy_ticket bt,users u where bt.owner_buy = u.id_user and u.user_id = ?1", nativeQuery = true)
    List<BuyEntity> findByOwner(String idUser);
    BuyEntity findByQr(String qr);
}
