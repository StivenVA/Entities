package org.clubhive.repositories.implement;

import FindUser.FindUser;
import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.DetailEntity;
import org.clubhive.model.Detail;
import org.clubhive.repositories.jpa.DetailRepositoryJpa;
import org.clubhive.utils.BuyMapper;
import org.clubhive.utils.DetailMapper;
import org.clubhive.utils.TicketMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Repository
public class DetailRepository {

    private final DetailRepositoryJpa detailRepository;

    public Detail save(Detail detail) {

        if (detail.getIdBuy() == null)
            throw new NoBugsException("Buy must not be null", HttpStatus.BAD_REQUEST);

        DetailEntity detailEntity = new DetailEntity();

        detailEntity.setIdBuyEntity(BuyMapper.mapToBuyEntity(detail.getIdBuy()));
        detailEntity.setQuantity(detail.getQuantity());
        detailEntity.setIdTicket(TicketMapper.modelToEntity(detail.getIdTicket()));
        
        return DetailMapper
                .mapToDetail(detailRepository.save(detailEntity));
    }

    public Detail findById(Long id) {
        return Stream.of(detailRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .map(DetailMapper::mapToDetail)
                .findFirst()
                .orElse(null);
    }

    public List<Detail> findByQr(String qr){

       FindUser<List<DetailEntity>,String> findByQr =
               (qrCode) -> detailRepository.findAll().stream()
               .filter(d->d.getIdBuyEntity().getQr().equals(qrCode)).toList();

       return findByQr.findBy(qr).stream().map(DetailMapper::mapToDetail).toList();
    }

}
