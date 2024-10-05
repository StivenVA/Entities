package org.clubhive.repositories.implement;

import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.EventEntity;
import org.clubhive.entities.PromoterEntity;
import org.clubhive.model.Promoter;
import org.clubhive.repositories.jpa.EventRepositoryJpa;
import org.clubhive.repositories.jpa.PromoterRepositoryJpa;
import org.clubhive.utils.PromoterMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PromoterRepository {

    private final PromoterRepositoryJpa promoterRepositoryJpa;
    private final EventRepositoryJpa eventRepositoryJpa;

    public List<Promoter> findAll() {
        return PromoterMapper.entityListToModelList(promoterRepositoryJpa.findAll());
    }

    public Promoter save(Promoter promoter) {
        EventEntity eventEntity = null;
        if (promoter.getEventId() != null) {
            try {
                if (!eventRepositoryJpa.existsById(promoter.getEventId())) {
                    throw new NoBugsException("Event not found", HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
            eventEntity = eventRepositoryJpa.findById(promoter.getEventId()).orElseThrow();
        }

        PromoterEntity promoterEntity = new PromoterEntity();

        try {
            if (promoterRepositoryJpa.findByCode(promoter.getCode()) != null) {
                throw new NoBugsException("Promoter already exists", HttpStatus.BAD_REQUEST);
            }
            if (promoter.getCode() == null) {
                throw new NoBugsException("Promoter code must not be null", HttpStatus.BAD_REQUEST);
            }
            if (promoter.getEventId() == null) {
                throw new NoBugsException("Event id must not be null", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        promoterEntity.setCode(promoter.getCode());
        promoterEntity.setEventId(eventEntity);

        return PromoterMapper.entityToModel(promoterRepositoryJpa.save(promoterEntity));
    }

    public Promoter findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id must not be null");

        PromoterEntity promoterFounded;
        try {
            promoterFounded = promoterRepositoryJpa.findById(id).orElse(null);
            if (promoterFounded == null) {
                throw new NoBugsException("Promoter not found", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return PromoterMapper.entityToModel(promoterRepositoryJpa.findById(id).orElseThrow());
    }

    public Promoter update(Promoter promoter) {
        try {
            if (!promoterRepositoryJpa.existsById(promoter.getId())) {
                throw new NoBugsException("Promoter not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        try {
            if (promoterRepositoryJpa.findByCode(promoter.getCode()) != null) {
                throw new NoBugsException("Promoter already exists", HttpStatus.BAD_REQUEST);
            }
            if (promoter.getCode() == null) {
                throw new NoBugsException("Promoter code must not be null", HttpStatus.BAD_REQUEST);
            }
            if (promoter.getEventId() == null) {
                throw new NoBugsException("Event id must not be null", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        PromoterEntity promoterEntity = promoterRepositoryJpa.findById(promoter.getId()).orElseThrow();
        promoterEntity.setCode(promoter.getCode());
        promoterEntity.setEventId(eventRepositoryJpa.findById(promoter.getEventId()).orElseThrow());
        return PromoterMapper.entityToModel(promoterRepositoryJpa.save(promoterEntity));
    }

    public void delete(Long id) {
        try {
            if (!promoterRepositoryJpa.existsById(id)) {
                throw new NoBugsException("Promoter not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new NoBugsException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        promoterRepositoryJpa.deleteById(id);
    }

    public List<Promoter> findByEvents(EventEntity event) {
        return PromoterMapper.entityListToModelList(promoterRepositoryJpa.findByEvent(event));
    }



}
