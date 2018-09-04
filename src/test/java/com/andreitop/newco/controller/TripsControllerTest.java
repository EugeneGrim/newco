package com.andreitop.newco.controller;

import com.andreitop.newco.common.ApiConstant;
import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.service.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TripsController.class)
public class TripsControllerTest {

    private static final String TRIP_JSON = "{\"origin\": \"LED\" , \"destination\":\"MOW\", \"price\" : 12256}";
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final String API_URL = ApiConstant.API_V_1 + "/trips";
    private static final TripDto TRIP_DTO = new TripDto();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TripService tripService;

    public TripsControllerTest() {
        TRIP_DTO.setId(1L);
        TRIP_DTO.setOrigin("MOW");
        TRIP_DTO.setDestination("LED");
        TRIP_DTO.setPrice(4232);
    }

    @Test
    public void whenPostTrip_thenCreateTrip() throws Exception {
        mockMvc.perform(post(API_URL)
                .contentType(CONTENT_TYPE)
                .content(TRIP_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenTrips_whenGetTrips_thenReturnJsonArray() throws Exception {
        List<TripDto> allTrips = Collections.singletonList(TRIP_DTO);
        given(tripService.findAll()).willReturn(allTrips);

        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(TRIP_DTO.getId().intValue())))
                .andExpect(jsonPath("$[0].origin", is(TRIP_DTO.getOrigin())))
                .andExpect(jsonPath("$[0].destination", is(TRIP_DTO.getDestination())))
                .andExpect(jsonPath("$[0].price", is(TRIP_DTO.getPrice())));
    }

    @Test
    public void givenTripById_whenGetTripById_thenReturnJsonArray() throws Exception {
        given(tripService.findById(TRIP_DTO.getId())).willReturn(TRIP_DTO);

        mockMvc.perform(get(API_URL + "/" + TRIP_DTO.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.id", is(TRIP_DTO.getId().intValue())))
                .andExpect(jsonPath("$.origin", is(TRIP_DTO.getOrigin())))
                .andExpect(jsonPath("$.destination", is(TRIP_DTO.getDestination())))
                .andExpect(jsonPath("$.price", is(TRIP_DTO.getPrice())));
    }

    @Test
    public void deleteTripById_whenDeleteTrip_thenReturnNoContentStatus() throws Exception {
        mockMvc.perform(delete(API_URL + "/" + TRIP_DTO.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateTripById_whenUpdateTripById_thenReturnOkStatus() throws Exception {
        mockMvc.perform(put(API_URL)
                .contentType(CONTENT_TYPE)
                .content(TRIP_JSON))
                .andExpect(status().isOk());
    }
}