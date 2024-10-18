package org.clubhive.repositories.implement;

import FindUser.FindUser;
import exceptions.NoBugsException;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.DetailEntity;
import org.clubhive.model.Detail;
import org.clubhive.model.Promoter;
import org.clubhive.model.Ticket;
import org.clubhive.repositories.jpa.DetailRepositoryJpa;
import org.clubhive.utils.BuyMapper;
import org.clubhive.utils.DetailMapper;
import org.clubhive.utils.EventMapper;
import org.clubhive.utils.TicketMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Repository
public class DetailRepository {

    private final DetailRepositoryJpa detailRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final PromoterRepository promoterRepository;

    @Transactional
    public Detail save(Detail detail) {
        
        if (detail.getIdBuy() == null)
            throw new NoBugsException("Buy must not be null", HttpStatus.BAD_REQUEST);
        
        DetailEntity detailEntity = new DetailEntity();
        
        detailEntity.setIdBuyEntity(BuyMapper.mapToBuyEntity(detail.getIdBuy()));
        detailEntity.setQuantity(detail.getQuantity());
        detailEntity.setIdTicket(TicketMapper.modelToEntity(detail.getIdTicket()));

        Ticket ticket = ticketRepository.findById(detail.getIdTicket().getId());

        detailEntity.getIdTicket().setEventId(EventMapper.mapEventToEventEntity(eventRepository.findById(Long.valueOf(ticket.getIdEvent()))));

        return DetailMapper
                .mapToDetail(detailRepository.save(detailEntity));
    }

    public Detail findById(Long id) {
        return Stream.of(detailRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .map(DetailMapper::mapToDetail)
                .findFirst()
                .orElse(null);
    }

    public List<Detail> findByQr(String qr){

       return detailRepository.findByQR(qr).stream().map(DetailMapper::mapToDetail).toList();
    }

    public Map<String,Integer> getPromotersDashboard(Long idEvent){

        List<Object[]> results = detailRepository.getPromoterDashBoard(idEvent);

        Map<String, Integer> promotersDashBoard = new HashMap<>();

        results.forEach(result -> promotersDashBoard.computeIfAbsent((String) result[0], k -> ((Number) result[1]).intValue()));

        List<Promoter> promotersEvent = promoterRepository.findByEvents(EventMapper.mapEventToEventEntity(eventRepository.findById(idEvent)));

        promotersEvent.forEach(promoter -> promotersDashBoard.computeIfAbsent(promoter.getCode(), k -> 0));

        return promotersDashBoard;
    }
}
