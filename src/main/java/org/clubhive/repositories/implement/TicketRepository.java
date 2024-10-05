package org.clubhive.repositories.implement;


import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.TicketEntity;
import org.clubhive.model.Event;
import org.clubhive.model.Ticket;
import org.clubhive.repositories.jpa.TicketRepositoryJpa;
import org.clubhive.utils.EventMapper;
import org.clubhive.utils.TicketMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TicketRepository {

    private final TicketRepositoryJpa ticketRepositoryJpa;
    private final EventRepository eventRepository;

    public Ticket save(Ticket ticket){

        Event event = eventRepository.findById(Long.valueOf(ticket.getIdEvent()));
        if (event == null) {
            throw new NoBugsException("Event not found", HttpStatus.NOT_FOUND);
        }

        TicketEntity ticketEntity = TicketMapper.modelToEntity(ticket);
        ticketEntity.setEventId(EventMapper.mapEventToEventEntity(event));

        return TicketMapper.entityToModel(ticketRepositoryJpa.save(ticketEntity));
    }

    public Ticket findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id must not be null");

        TicketEntity ticketFounded;

        try {
             ticketFounded = ticketRepositoryJpa.findById(id).orElse(null);
            if (ticketFounded == null) {
                throw new NoBugsException("Ticket not found", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return TicketMapper.entityToModel(ticketFounded);
    }

    public List<Ticket> saveAll(List<Ticket> tickets){
        return tickets.stream().map(this::save).toList();
    }

    public Ticket deleteTicket(Long id){
        Ticket ticket = findById(id);
        ticketRepositoryJpa.delete(TicketMapper.modelToEntity(ticket));
        return ticket;
    }

    public List<Ticket> findAllByIdEvent(String idEvent){
        if (idEvent == null)
            throw new IllegalArgumentException("IdEvent must not be null");

        List<TicketEntity> tickets = null;
        try {
            tickets = ticketRepositoryJpa.findAllByEventId(Long.valueOf(idEvent));

            if (tickets.isEmpty()) {
                throw new NoBugsException("Tickets not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return tickets.stream().map(TicketMapper::entityToModel).toList();
    }
}
