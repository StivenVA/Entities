package org.clubhive.repositories.implement;

import FindUser.FindUser;
import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.BuyTicketStatus;
import org.clubhive.entities.PromoterEntity;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Buy;
import org.clubhive.model.Customer;
import org.clubhive.repositories.jpa.BuyRepositoryJpa;
import org.clubhive.utils.BuyMapper;
import org.clubhive.utils.GenericMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class BuyRepository {

    private final BuyRepositoryJpa buyRepositoryJpa;

    public Buy save(Buy buy) {

        if (buy.getOwner() == null)
            throw new NoBugsException("Owner must not be null", HttpStatus.BAD_REQUEST);

        return Stream.of(BuyMapper.mapToBuyEntity(buy)).map(buyRepositoryJpa::save).map(BuyMapper::mapToBuy).findFirst().orElseThrow(() -> new NoBugsException("Error saving buy", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    public Buy findById(Long id) {
        return Stream.of(buyRepositoryJpa.findById(id).orElse(null)).filter(Objects::nonNull).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }

    public Buy findByQr(String qr) {
        FindUser<BuyEntity,String> findByQr = (qrCode) -> buyRepositoryJpa.findAll().stream().filter(b -> b.getQr().equals(qrCode)).findFirst().orElse(null);

        return Stream.of(findByQr.findBy(qr)).filter(Objects::nonNull).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }

    public List<Buy> findBuyByOwner(Customer customer) {
        return buyRepositoryJpa.findByOwner(GenericMapper.map(customer, UserEntity.class)).stream().map(BuyMapper::mapToBuy).toList();
    }
}
