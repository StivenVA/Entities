package org.clubhive.utils;

import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.DTO.*;
import org.clubhive.DTO.auth.CustomerResponseDTO;
import org.clubhive.entities.BuyEntity;
import org.clubhive.entities.BuyTicketStatus;
import org.clubhive.entities.PromoterEntity;
import org.clubhive.entities.UserEntity;
import org.clubhive.model.Buy;
import org.clubhive.model.Customer;
import org.clubhive.model.Detail;
import org.clubhive.model.Promoter;
import org.clubhive.repositories.implement.DetailRepository;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
public class BuyMapper {

    public static BuyDTO mapToBuyDTO(Buy buy){
        if (buy == null) return null;

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
        if (buyDTO == null) return null;

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
        buy.setServiceFee(buyDTO.getServiceFee());

        if (buyDTO.getDetails() !=null && !buyDTO.getDetails().isEmpty()){
            buy.setDetails(buyDTO.getDetails().stream().map(DetailMapper::DetailDTOTOModel).toList());
        }

        return buy;
    }

    public static Buy mapToBuy(BuyEntity buy){

        if (buy == null) return null;

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
        buyModel.setServiceFee(buy.getServiceFee());
        
        return buyModel;
    }

    public static BuyEntity mapToBuyEntity(Buy buy){

        if (buy == null) return null;

        BuyEntity buyEntity = new BuyEntity();
        buyEntity.setId(buy.getId() == null ? 0 : buy.getId());
        buyEntity.setQr(buy.getQr());
        buyEntity.setClaim(buy.getClaim() != null && buy.getClaim());
        buyEntity.setOwner(buy.getOwner()==null?null:GenericMapper.map(buy.getOwner(), UserEntity.class));
        buyEntity.setIdPromoter(buy.getIdPromoter() == null? null : GenericMapper.map(buy.getIdPromoter(), PromoterEntity.class));
        buyEntity.setStateBuy(BuyTicketStatus.valueOf(buy.getStateBuy()));
        buyEntity.setReference(buy.getReference());
        buyEntity.setTotal(buy.getTotal());
        buyEntity.setDate(buy.getDate());
        buyEntity.setServiceFee(buy.getServiceFee());

        return buyEntity;
    }

    public static BuyCustomerDTO mapToBuyCustomer(Buy buy){
        if (buy == null) return null;

        if (buy.getDetails() == null || buy.getDetails().isEmpty())
            throw new NoBugsException("There are not tickets", HttpStatus.BAD_REQUEST);

        BuyCustomerDTO buyCustomerDTO = new BuyCustomerDTO();
        buyCustomerDTO.setQr(buy.getQr());
        buyCustomerDTO.setClaim(buy.getClaim());
        buyCustomerDTO.setStateBuy(buy.getStateBuy());
        buyCustomerDTO.setReference(buy.getReference());
        buyCustomerDTO.setTotal(buy.getTotal());
        buyCustomerDTO.setDate(buy.getDate());
        buyCustomerDTO.setServiceFee(buy.getServiceFee());
        buyCustomerDTO.setOwner(buy.getOwner()==null?null:GenericMapper.map(buy.getOwner(), CustomerDTO.class));

        buyCustomerDTO.setTickets(buy.getDetails().stream().map(detail->{

            TicketSaleDTO ticketSaleDTO = new TicketSaleDTO();
            ticketSaleDTO.setName(detail.getIdTicket().getName());
            ticketSaleDTO.setPrice(detail.getIdTicket().getPrice());
            ticketSaleDTO.setQuantity(detail.getQuantity());
            ticketSaleDTO.setDesc(detail.getIdTicket().getDesc());

            return ticketSaleDTO;
        }).toList());

        buyCustomerDTO.setPromoter(buy.getIdPromoter() == null ? null : PromoterMapper.modelToDTO(buy.getIdPromoter()));

        return buyCustomerDTO;
    }

}
