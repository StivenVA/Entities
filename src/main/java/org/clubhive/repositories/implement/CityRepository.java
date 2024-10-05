package org.clubhive.repositories.implement;


import exceptions.NoBugsException;
import lombok.RequiredArgsConstructor;
import org.clubhive.entities.CityEntity;
import org.clubhive.model.City;
import org.clubhive.repositories.jpa.CityRepositoryJpa;
import org.clubhive.utils.GenericMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityRepository {

    private final CityRepositoryJpa cityRepositoryJpa;

    public City findByName(String name) {

        if (name == null)
            throw new NoBugsException("City name must not be null", HttpStatus.BAD_REQUEST);

        CityEntity city = cityRepositoryJpa.findByName(name);

        if (city == null) {
            throw new NoBugsException("City not found", HttpStatus.NOT_FOUND);
        }

        return GenericMapper.map(city, City.class);
    }

    public List<City> findAll(){
        return GenericMapper.mapList(cityRepositoryJpa.findAll(), City.class);
    }

    public City findById(long id){
        return GenericMapper.map(cityRepositoryJpa.findById(id),City.class);
    }
}
