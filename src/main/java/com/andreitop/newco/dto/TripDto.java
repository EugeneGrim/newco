package com.andreitop.newco.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TripDto implements TripEntity {

    private static final long serialVersionUID = 5914366185889783660L;

    private Long id;
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$", message = "Incorrect origin place code")
    private String origin;
    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$", message = "Incorrect destination place code")
    private String destination;
    @NotNull
    @Range(min = 0, max = 500000)
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
