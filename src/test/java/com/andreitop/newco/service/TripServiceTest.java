package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(TripService.class)
public class TripServiceTest {

    private static final TripDto TRIP_ENTITY = new TripDto();

    public TripServiceTest() {
        TRIP_ENTITY.setId(1L);
        TRIP_ENTITY.setOrigin("LED");
        TRIP_ENTITY.setDestination("MOW");
        TRIP_ENTITY.setPrice(12256);
    }

    @Autowired
    private SimpleService<TripDto> service;

    @MockBean
    private TripRepository tripRepository;

    @Test
    public void findAll() {
        List<TripDto> allTrips = Collections.singletonList(TRIP_ENTITY);

        given(tripRepository.findAll()).willReturn(allTrips);

        Assert.assertEquals(service.findAll(), allTrips);
    }

    @Test
    public void findById() {
        given(tripRepository.findById(TRIP_ENTITY.getId())).willReturn(TRIP_ENTITY);
        Assert.assertEquals(service.findById(TRIP_ENTITY.getId()), TRIP_ENTITY);
    }

    @Test
    public void save() {
        service.save(TRIP_ENTITY);
        verify(tripRepository).save(TRIP_ENTITY);
    }

    @Test
    public void delete() {
        service.delete(TRIP_ENTITY.getId());
        verify(tripRepository).delete(TRIP_ENTITY.getId());
    }

    @Test
    public void update() {
        service.update(TRIP_ENTITY);
        verify(tripRepository).update(TRIP_ENTITY);
    }
}