package org.clubhive.utils;


import org.clubhive.DTO.EventDTO;
import org.clubhive.DTO.PromoterDTO;
import org.clubhive.DTO.TicketDTO;
import org.clubhive.entities.CityEntity;
import org.clubhive.entities.EventEntity;
import org.clubhive.model.Event;
import org.clubhive.model.Promoter;
import org.clubhive.model.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class EventMapper {

    public static Event mapEventEntityToEventModel(EventEntity eventEntity) {

        Event event = new GenericMapper().map(eventEntity, Event.class);
        event.setOrgnzId(eventEntity.getOrgnzId().getOrganizerId());
        event.setCityId(eventEntity.getCity().getId());
        event.setLocation(event.getLocation());

        return event;
    }

    public static EventDTO mapEventModelToEventDTO(Event event) {
        return new GenericMapper().map(event, EventDTO.class);
    }

    public static List<Event> mapEventEntityListToEventList(List<EventEntity> eventEntityList) {
        return eventEntityList.stream()
                .map(EventMapper::mapEventEntityToEventModel).toList();
    }

    public static List<EventDTO> mapEventListToEventDTOList(List<Event> eventList) {
        return eventList.stream()
                .map(EventMapper::mapEventModelToEventDTO)
                .toList();
    }

    public static Event mapEventDTOToEvent(EventDTO eventDTO) {
        Event event = new GenericMapper().map(eventDTO, Event.class);
        List<Promoter> promoters = null;
        List<Ticket> tickets = null;
        if (eventDTO.getPromoters() != null)
            promoters = new GenericMapper().mapList(eventDTO.getPromoters(), Promoter.class);
        if (eventDTO.getTickets() != null)
            tickets = new GenericMapper().mapList(eventDTO.getTickets(), Ticket.class);
        event.setPromoters(promoters);
        event.setTickets(tickets);
        event.setCityId(eventDTO.getCityId());
        return event;
    }

    public static EventDTO mapEventToEventDTO(Event event) {
        EventDTO eventDTO = new GenericMapper().map(event, EventDTO.class);
        List<PromoterDTO> promoters = new GenericMapper().mapList(event.getPromoters(), PromoterDTO.class);
        List<TicketDTO> tickets = new GenericMapper().mapList(event.getTickets(), TicketDTO.class);
        eventDTO.setPromoters(promoters);
        eventDTO.setTickets(tickets);
        return eventDTO;
    }

    public static EventEntity mapEventToEventEntity(Event event) {
        EventEntity eventEntity = new EventEntity();

        eventEntity.setId(event.getId());
        eventEntity.setName(event.getName());
        eventEntity.setDate(LocalDate.parse(event.getDate()));
        eventEntity.setImg(event.getImg());
        eventEntity.setDesc(event.getDesc());
        eventEntity.setTime(LocalTime.parse(event.getTime()));
        eventEntity.setState(event.getState());
        eventEntity.setCity(new CityEntity(event.getId(), ""));
        eventEntity.setLocation(event.getLocation());

        return eventEntity;
    }
}
