package org.clubhive.utils;

import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Buy;
import org.clubhive.model.Customer;

public class BuyMapper {

    public static Buy mapToBuy(BuyEntity buy){
        return new Buy(buy.getId(), buy.getQr(), buy.isState(), GenericMapper.map(buy.getOwner(), Customer.class), PromoterMapper.entityToModel(buy.getIdPromoter()));
    }

    public static BuyEntity mapToBuyEntity(Buy buy){

        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setId(buy.getId());
        buyEntity.setQr(buy.getQr());
        buyEntity.setState(buy.isState());
        buyEntity.setOwner(GenericMapper.map(buy.getOwner(), UserEntity.class));
        buyEntity.setIdPromoter(PromoterMapper.modelToEntity(buy.getIdPromoter()));

        return buyEntity;
    }

}
