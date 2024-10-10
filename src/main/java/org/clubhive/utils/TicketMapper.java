package org.clubhive.utils;


import org.clubhive.DTO.TicketDTO;
import org.clubhive.entities.TicketEntity;
import org.clubhive.model.Ticket;

import java.util.List;

public class TicketMapper {

    public static List<Ticket> mapTicketEntityListToTicketModelList(List<TicketEntity> ticketsList){
        return ticketsList.stream()
                .map(TicketMapper::entityToModel)
                .toList();
    }

    public static List<TicketDTO> mapTicketModelListToTicketDTOList(List<Ticket> ticketsList){
        return ticketsList.stream()
                .map(TicketMapper::modelToDTO)
                .toList();
    }

    public static List<Ticket> mapTicketDTOListToTicketModelList(List<TicketDTO> ticketsList){
        return ticketsList.stream()
                .map(TicketMapper::dtoToModel)
                .toList();
    }

    public static Ticket dtoToModel(TicketDTO ticketDTO){
        return GenericMapper.map(ticketDTO, Ticket.class);
    }

    public static TicketDTO modelToDTO(Ticket ticket){
        return GenericMapper.map(ticket, TicketDTO.class);
    }

    public static Ticket entityToModel(TicketEntity ticketEntity){
        Ticket ticket = GenericMapper.map(ticketEntity, Ticket.class);
        ticket.setIdEvent(String.valueOf(ticketEntity.getEventId().getId()));

        return ticket;
    }


    public static TicketEntity modelToEntity(Ticket ticket){
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setId(ticket.getId());
        ticketEntity.setName(ticket.getName());
        ticketEntity.setDesc(ticket.getDesc());
        ticketEntity.setPrice(ticket.getPrice());
        ticketEntity.setQua(ticket.getQua());
        ticketEntity.setState(ticket.getState());
        ticketEntity.setAvailable(ticket.getAvailable());
        return ticketEntity;
    }
}
