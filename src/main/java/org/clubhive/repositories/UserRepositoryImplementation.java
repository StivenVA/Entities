package org.clubhive.repositories;

import org.clubhive.model.User;

import java.util.List;

public interface UserRepositoryImplementation<T extends User> {

    T update(T model);
    T save(T model);
    List<T> findAll();
}
