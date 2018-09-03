package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripEntity;

import java.util.List;

public interface SimpleController<E extends TripEntity> {

    List<E> findAll();

    E findById(final Long id);

    void create(final E entity);

    void delete(final Long id);

    void update(final E newEntity);
}
