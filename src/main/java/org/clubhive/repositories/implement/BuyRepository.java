package org.clubhive.repositories.implement;

import FindUser.FindUser;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.BuyEntity;
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
        return Stream.of(buyRepositoryJpa.save(GenericMapper.map(buy,BuyEntity.class))).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }

    public Buy findById(Long id) {
        return Stream.of(buyRepositoryJpa.findById(id).orElse(null)).filter(Objects::nonNull).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }

    public Buy findByQr(String qr) {
        FindUser<BuyEntity,String> findByQr = (qrCode) -> buyRepositoryJpa.findAll().stream().filter(b -> b.getQr().equals(qrCode)).findFirst().orElse(null);

        return Stream.of(findByQr.findBy(qr)).filter(Objects::nonNull).map(BuyMapper::mapToBuy).findFirst().orElse(null);
    }
}
