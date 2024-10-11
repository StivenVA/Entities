package org.clubhive.utils;


import org.clubhive.DTO.PromoterDTO;
import org.clubhive.entities.PromoterEntity;
import org.clubhive.model.Promoter;

import java.util.List;

public class PromoterMapper {

    public static Promoter dtoToModel(PromoterDTO promoterDTO) {
        return GenericMapper.map(promoterDTO, Promoter.class);
    }

    public static Promoter entityToModel(PromoterEntity promoterEntity) {
        if (promoterEntity.getEventId() != null) {
            return new Promoter(promoterEntity.getId(), promoterEntity.getCode(), promoterEntity.getEventId().getId());
        } else {
            return new Promoter(promoterEntity.getId(), promoterEntity.getCode(), null);
        }

    }

    public static PromoterEntity modelToEntity(Promoter promoter) {
        PromoterEntity promoterEntity = new PromoterEntity();
        promoterEntity.setId(promoter.getId());
        promoterEntity.setCode(promoter.getCode());
        return promoterEntity;
    }

    public static PromoterDTO modelToDTO(Promoter promoter) {
        return new PromoterDTO(promoter.getId(), promoter.getCode(), promoter.getEventId());
    }

    public static List<Promoter> entityListToModelList(List<PromoterEntity> all) {
        return all.stream().map(PromoterMapper::entityToModel).toList();
    }
}
