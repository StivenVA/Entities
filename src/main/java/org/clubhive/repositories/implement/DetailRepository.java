package org.clubhive.repositories.implement;

import FindUser.FindUser;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.DetailEntity;
import org.clubhive.model.Detail;
import org.clubhive.repositories.jpa.DetailRepositoryJpa;
import org.clubhive.utils.DetailMapper;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Repository
public class DetailRepository {

    private final DetailRepositoryJpa detailRepository;

    public Detail save(Detail detail) {
        return Stream.of(detailRepository.save(DetailMapper.mapToDetailEntity(detail))).map(DetailMapper::mapToDetail).findFirst().orElse(null);
    }

    public Detail findById(Long id) {
        return Stream.of(detailRepository.findById(id).orElse(null)).filter(Objects::nonNull).map(DetailMapper::mapToDetail).findFirst().orElse(null);
    }

    public Detail findByQr(String qr){

       FindUser<DetailEntity,String> findByQr = (qrCode) -> detailRepository.findAll().stream().filter(d->d.getIdBuyEntity().getQr().equals(qrCode)).findFirst().orElse(null);

       return Stream.of(findByQr.findBy(qr)).filter(Objects::nonNull).map(DetailMapper::mapToDetail).findFirst().orElse(null);
    }

}
