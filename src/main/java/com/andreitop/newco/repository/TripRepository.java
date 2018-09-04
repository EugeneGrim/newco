package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepository<E extends TripEntity> implements SimpleRepository<E> {

    private final List<E> trips = new ArrayList<>();

    public List<E> findAll() {
        return trips;
    }

    public E findById(final Long id) {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(final E trip) {
        trip.setId((long) (trips.size() + 1));
        trips.add(trip);
    }

    public void delete(final Long id) {
        trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(trips::remove);
    }

    public void update(final E newTrip) {
        trips.stream()
                .filter(t -> t.getId().equals(newTrip.getId()))
                .findFirst()
                .ifPresent(t -> trips.set(trips.indexOf(t), newTrip));
    }
}
