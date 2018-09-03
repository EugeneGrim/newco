package com.andreitop.newco.dto;

public interface TripEntity {

    Long getId();

    void setId(Long id);

    String getOrigin();

    void setOrigin(String origin);

    String getDestination();

    void setDestination(String destination);

    Integer getPrice();

    void setPrice(Integer price);
}
