package org.clubhive.repositories.implement;

import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.KeeperEntity;
import org.clubhive.entities.OrganizerEntity;
import org.clubhive.model.Keeper;
import org.clubhive.model.Organizer;
import org.clubhive.repositories.UserRepositoryImplementation;
import org.clubhive.repositories.jpa.KeeperRepository;
import org.clubhive.utils.GenericMapper;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class KeeperRepoImpl implements UserRepositoryImplementation<Keeper> {

    private final KeeperRepository keeperRepository;
    private final OrganizerRepoImpl organizerRepository;

    @Override
    public Keeper update(Keeper model) {
        Keeper keeperToUpdate = null;
        try {
            keeperToUpdate = GenericMapper.map(keeperRepository.findByKeeperId(model.getKeeperId()), Keeper.class);

            if (keeperToUpdate == null)
                throw new NullPointerException();
        } catch (Exception e) {
            throw new NoBugsException("Keeper not found", HttpStatus.NOT_FOUND);
        }

        keeperToUpdate.setPhone(model.getPhone() == null ? keeperToUpdate.getPhone() : model.getPhone());
        keeperToUpdate.setEmail(model.getEmail() == null ? keeperToUpdate.getEmail() : model.getEmail());
        keeperToUpdate.setName(model.getName() == null ? keeperToUpdate.getName() : model.getName());

        return save(keeperToUpdate);
    }

    @Override
    public Keeper save(Keeper model) {
        KeeperEntity keeperToSave = GenericMapper.map(model, KeeperEntity.class);
        keeperToSave.setOrganizer(GenericMapper.map(organizerRepository.findById(model.getOrganizerId()), OrganizerEntity.class));

        return GenericMapper.map(keeperRepository.save(keeperToSave),Keeper.class);
    }

    @Override
    public List<Keeper> findAll() {
       return GenericMapper.mapList(keeperRepository.findAll(), Keeper.class);

    }

    public List<Keeper> findAllByOrganizer(Organizer organizer) {
        return GenericMapper.mapList(keeperRepository.findAllByOrganizer(GenericMapper.map(organizer, OrganizerEntity.class)), Keeper.class);
    }

    public Keeper findById(Long id){
        return GenericMapper.map(keeperRepository.findById(id).orElseThrow(()->new NoBugsException("Keeper not found", HttpStatus.NOT_FOUND)),Keeper.class);
    }
}
