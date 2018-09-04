package com.andreitop.newco.dto;

import java.io.Serializable;

public interface TripEntity extends Serializable {

    Long getId();

    void setId(Long id);

    String getOrigin();

    void setOrigin(String origin);

    String getDestination();

    void setDestination(String destination);

    Integer getPrice();

    void setPrice(Integer price);
}
