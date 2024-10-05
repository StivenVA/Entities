package org.clubhive.repositories.implement;



import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.OrganizerEntity;
import org.clubhive.model.Organizer;
import org.clubhive.repositories.UserRepositoryImplementation;
import org.clubhive.repositories.jpa.OrganizerRepository;
import org.clubhive.utils.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepoImpl implements UserRepositoryImplementation<Organizer> {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    public Organizer save(Organizer organizer){
        if (organizerRepository.existsByOrganizerId(organizer.getOrganizerId())) {
            throw new IllegalArgumentException("Organizer already exist");
        }

        OrganizerEntity organizerEntity = new OrganizerEntity();
        organizerEntity.setOrganizerId(organizer.getOrganizerId());
        organizerEntity.setUrlPay(organizer.getUrlPay());
        organizerEntity.setName(organizer.getName());
        organizerEntity.setEmail(organizer.getEmail());

        return GenericMapper.map(organizerRepository.save(organizerEntity),Organizer.class);
    }

    @Override
    public List<Organizer> findAll(){
        return GenericMapper.mapList(organizerRepository.findAll(),Organizer.class);
    }

    @Override
    public Organizer update(Organizer organizer){

        OrganizerEntity organizerEntity = organizerRepository.findByOrganizerId(organizer.getOrganizerId());

        organizerEntity.setUrlPay((organizer.getUrlPay() != null) ? organizer.getUrlPay() : organizerEntity.getUrlPay());
        organizerEntity.setName((organizer.getName() != null) ? organizer.getName() : organizerEntity.getName());

        return GenericMapper.map(organizerRepository.save(organizerEntity),Organizer.class);
    }

    public Organizer findById(Long id){

        return GenericMapper.map(organizerRepository.findById(id).orElseThrow(()->new NoBugsException("Organizer not found", HttpStatus.NOT_FOUND)),Organizer.class);
    }
}
