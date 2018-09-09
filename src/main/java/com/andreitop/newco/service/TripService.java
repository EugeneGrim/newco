package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TripService {

    private TripJpaRepository tripRepository;

    @Autowired
    public TripService(TripJpaRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public List<TripDto> findAll() {
        return tripRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public TripDto findById(Long id) {
        return tripRepository.findById(id).isPresent() ? tripRepository.findById(id).get() : null;
    }

    public void save(TripDto trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    public void update(TripDto newTrip) {
        tripRepository.save(newTrip);
    }
}
