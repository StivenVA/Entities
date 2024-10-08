package org.clubhive.utils;

import lombok.RequiredArgsConstructor;
import org.clubhive.entities.DetailEntity;
import org.clubhive.model.Detail;
import org.clubhive.repositories.jpa.DetailRepositoryJpa;

@RequiredArgsConstructor
public class DetailMapper {

    private final DetailRepositoryJpa detailRepositoryJpa;


    public static Detail mapToDetail(DetailEntity detail){
        return new Detail(detail.getId(), TicketMapper.entityToModel(detail.getIdTicket()), detail.getQuantity(),null);
    }

    public static DetailEntity mapToDetailEntity(Detail detail){

        DetailEntity detailEntity = new DetailEntity();
        detailEntity.setId(detail.getId());
        detailEntity.setQuantity(detail.getQuantity());
        detailEntity.setIdTicket(TicketMapper.modelToEntity(detail.getIdTicket()));
        detailEntity.setIdBuyEntity(BuyMapper.mapToBuyEntity(detail.getIdBuy()));

        return detailEntity;
    }

}
