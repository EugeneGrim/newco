package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripEntity;

import java.util.List;

public interface SimpleService<E extends TripEntity> {

    List<E> findAll();

    E findById(Long id);

    void save(E entity);

    void delete(Long id);

    void update(E newEntity);
}
