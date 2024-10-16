package org.clubhive.utils;

import lombok.RequiredArgsConstructor;
import org.clubhive.DTO.BuyDTO;
import org.clubhive.DTO.DetailDTO;
import org.clubhive.DTO.UserResponseDTO;
import org.clubhive.DTO.auth.CustomerResponseDTO;
import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.BuyTicketStatus;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Buy;
import org.clubhive.model.Customer;
import org.clubhive.model.Detail;
import org.clubhive.model.Promoter;
import org.clubhive.repositories.implement.DetailRepository;

import java.util.ArrayList;

@RequiredArgsConstructor
public class BuyMapper {

    public static BuyDTO mapToBuyDTO(Buy buy){
        BuyDTO buyDTO = new BuyDTO();

        buyDTO.setId(buy.getId());
        buyDTO.setQr(buy.getQr());
        buyDTO.setClaim(buy.getClaim());
        buyDTO.setOwner(buy.getOwner() == null?null:GenericMapper.map(buy.getOwner(), CustomerResponseDTO.class));
        buyDTO.setIdPromoter(buy.getIdPromoter()==null?null:PromoterMapper.modelToDTO(buy.getIdPromoter()));
        buyDTO.setStateBuy(buy.getStateBuy());
        buyDTO.setReference(buy.getReference());
        buyDTO.setTotal(buy.getTotal());
        buyDTO.setDate(buy.getDate());
        buyDTO.setServiceFee(buy.getServiceFee());

        if(buy.getDetails() != null && !buy.getDetails().isEmpty())
            buyDTO.setDetails(buy.getDetails().stream().map(DetailMapper::mapToDetailDTO).toList());

        return buyDTO;
    }

    public static Buy mapToBuy(BuyDTO buyDTO){

        Buy buy = new Buy();

        buy.setId(buyDTO.getId());
        buy.setQr(buyDTO.getQr());
        buy.setClaim(buyDTO.getClaim());
        buy.setOwner(buyDTO.getOwner()==null?null:GenericMapper.map(buyDTO.getOwner(), Customer.class));
        buy.setIdPromoter(buyDTO.getIdPromoter()==null?null:PromoterMapper.dtoToModel(buyDTO.getIdPromoter()));
        buy.setStateBuy(buyDTO.getStateBuy());
        buy.setReference(buyDTO.getReference());
        buy.setDetails(GenericMapper.mapList(buyDTO.getDetails(), Detail.class));
        buy.setTotal(buyDTO.getTotal());
        buy.setDate(buyDTO.getDate());

        if (buyDTO.getDetails() !=null && !buyDTO.getDetails().isEmpty()){
            buy.setDetails(buyDTO.getDetails().stream().map(DetailMapper::DetailDTOTOModel).toList());
        }

        return buy;
    }

    public static Buy mapToBuy(BuyEntity buy){

        Buy buyModel = new Buy();
        buyModel.setId(buy.getId());
        buyModel.setQr(buy.getQr());
        buyModel.setClaim(buy.isClaim());
        buyModel.setOwner(buy.getOwner()==null?null:GenericMapper.map(buy.getOwner(), Customer.class));
        buyModel.setIdPromoter(buy.getIdPromoter()==null?null:PromoterMapper.entityToModel(buy.getIdPromoter()));
        buyModel.setStateBuy(buy.getStateBuy().name());
        buyModel.setReference(buy.getReference());
        buyModel.setTotal(buy.getTotal());
        buyModel.setDate(buy.getDate());
        
        return buyModel;
    }

    public static BuyEntity mapToBuyEntity(Buy buy){

        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setId(buy.getId());
        buyEntity.setQr(buy.getQr());
        buyEntity.setClaim(buy.getClaim());
        buyEntity.setOwner(buy.getOwner()==null?null:GenericMapper.map(buy.getOwner(), UserEntity.class));
        buyEntity.setIdPromoter(buy.getIdPromoter()==null?null:PromoterMapper.modelToEntity(buy.getIdPromoter()));
        buyEntity.setStateBuy(BuyTicketStatus.valueOf(buy.getStateBuy()));
        buyEntity.setReference(buy.getReference());
        buyEntity.setTotal(buy.getTotal());
        buyEntity.setDate(buy.getDate());

        return buyEntity;
    }

}
