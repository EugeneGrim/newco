package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripEntity;

import java.util.List;

public interface SimpleRepository<E extends TripEntity> {

    List<E> findAll();

    E findById(final Long id);

    void save(final E entity);

    void delete(final Long id);

    void update(final E newEntity);
}
