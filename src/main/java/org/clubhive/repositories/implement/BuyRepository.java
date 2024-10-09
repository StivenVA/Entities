package org.clubhive.repositories.implement;

import FindUser.FindUser;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.BuyTicketStatus;
import org.clubhive.entities.PromoterEntity;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Buy;
import org.clubhive.repositories.jpa.BuyRepositoryJpa;
import org.clubhive.utils.BuyMapper;
import org.clubhive.utils.GenericMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class BuyRepository {

    private final BuyRepositoryJpa buyRepositoryJpa;

    public Buy save(Buy buy) {
        
        return Stream.of(new BuyEntity()).peek(buyToRegistry -> {
            buyToRegistry.setClaim(false);
            buyToRegistry.setStateBuy(BuyTicketStatus.valueOf(buy.getStateBuy()));
            buyToRegistry.setQr(buy.getQr());
            buyToRegistry.setReference(buy.getReference());
            buyToRegistry.setOwner(GenericMapper.map(buy.getOwner(), UserEntity.class));
            buyToRegistry.setIdPromoter(buy.getIdPromoter() == null? null : GenericMapper.map(buy.getIdPromoter(), PromoterEntity.class));
            buyToRegistry.setTotal(buy.getTotal());
            buyToRegistry.setDate(buy.getDate());

        }).map(buyRepositoryJpa::save).map(BuyMapper::mapToBuy).findFirst().orElse(null);


    }

    public Buy findById(Long id) {
        return Stream.of(buyRepositoryJpa.findById(id).orElse(null)).filter(Objects::nonNull).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }

    public Buy findByQr(String qr) {
        FindUser<BuyEntity,String> findByQr = (qrCode) -> buyRepositoryJpa.findAll().stream().filter(b -> b.getQr().equals(qrCode)).findFirst().orElse(null);

        return Stream.of(findByQr.findBy(qr)).filter(Objects::nonNull).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }
}
