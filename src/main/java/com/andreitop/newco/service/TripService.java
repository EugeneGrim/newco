package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.dto.TripEntity;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService<E extends TripDto, R extends TripRepository<E>> implements SimpleService<E>{

    private final R tripRepository;

    @Autowired
    public TripService(R tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<E> findAll() {
        return tripRepository.findAll();
    }

    public E findById(Long id) {
        return tripRepository.findById(id);
    }

    public void save(E trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.delete(id);
    }

    public void update(E newTrip) {
        tripRepository.update(newTrip);
    }
}
