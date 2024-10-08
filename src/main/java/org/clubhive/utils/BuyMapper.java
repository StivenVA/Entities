package org.clubhive.utils;

import org.clubhive.DTO.BuyDTO;
import org.clubhive.DTO.DetailDTO;
import org.clubhive.DTO.UserResponseDTO;
import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.BuyTicketStatus;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Buy;
import org.clubhive.model.Customer;
import org.clubhive.model.Detail;
import org.clubhive.model.Promoter;

public class BuyMapper {

    public static BuyDTO mapToBuyDTO(Buy buy){
        BuyDTO buyDTO = new BuyDTO();

        buyDTO.setId(buy.getId());
        buyDTO.setQr(buy.getQr());
        buyDTO.setState(buy.getState());
        buyDTO.setOwner(GenericMapper.map(buy.getOwner(), UserResponseDTO.class));
        buyDTO.setIdPromoter(PromoterMapper.modelToDTO(buy.getIdPromoter()));
        buyDTO.setStateBuy(buy.getStateBuy());
        buyDTO.setReference(buy.getReference());
        buyDTO.setDetails(GenericMapper.mapList(buy.getDetails(), DetailDTO.class));

        return buyDTO;
    }

    public static Buy mapToBuy(BuyDTO buyDTO){

        Buy buy = new Buy();

        buy.setId(buyDTO.getId());
        buy.setQr(buyDTO.getQr());
        buy.setState(buyDTO.getState());
        buy.setOwner(GenericMapper.map(buyDTO.getOwner(), Customer.class));
        buy.setIdPromoter(GenericMapper.map(buyDTO.getIdPromoter(), Promoter.class));
        buy.setStateBuy(buyDTO.getStateBuy());
        buy.setReference(buyDTO.getReference());
        buy.setDetails(GenericMapper.mapList(buyDTO.getDetails(), Detail.class));

        return buy;
    }

    public static Buy mapToBuy(BuyEntity buy){
        return new Buy(buy.getId(), buy.getQr(), buy.isState(), GenericMapper.map(buy.getOwner(), Customer.class), PromoterMapper.entityToModel(buy.getIdPromoter()), buy.getStateBuy().name(), buy.getReference(),null);
    }

    public static BuyEntity mapToBuyEntity(Buy buy){

        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setId(buy.getId());
        buyEntity.setQr(buy.getQr());
        buyEntity.setState(buy.getState());
        buyEntity.setOwner(GenericMapper.map(buy.getOwner(), UserEntity.class));
        buyEntity.setIdPromoter(PromoterMapper.modelToEntity(buy.getIdPromoter()));
        buyEntity.setStateBuy(BuyTicketStatus.valueOf(buy.getStateBuy()));

        return buyEntity;
    }

}
