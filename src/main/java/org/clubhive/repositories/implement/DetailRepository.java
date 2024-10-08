package org.clubhive.repositories.implement;

import FindUser.FindUser;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.DetailEntity;
import org.clubhive.model.Detail;
import org.clubhive.repositories.jpa.DetailRepositoryJpa;
import org.clubhive.utils.DetailMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Repository
public class DetailRepository {

    private final DetailRepositoryJpa detailRepository;

    public Detail save(Detail detail) {
        return DetailMapper
                .mapToDetail(detailRepository.save(DetailMapper.mapToDetailEntity(detail)));
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
               .filter(d->d.getIdBuyEntity().getQr().equals(qrCode))
               .toList();

       return findByQr.findBy(qr).stream().map(DetailMapper::mapToDetail).toList();
    }

}
