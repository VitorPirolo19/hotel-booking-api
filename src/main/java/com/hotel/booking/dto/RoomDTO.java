package com.hotel.booking.dto;

import com.hotel.booking.enums.RoomTypes;

import java.math.BigDecimal;

public class RoomDTO {
    private Integer number;
    private RoomTypes room_type;
    private String description;
    private Integer capacity_of_people;
    private BigDecimal price_per_night;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public RoomTypes getRoom_type() {
        return room_type;
    }

    public void setRoom_type(RoomTypes room_type) {
        this.room_type = room_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity_of_people() {
        return capacity_of_people;
    }

    public void setCapacity_of_people(Integer capacity_of_people) {
        this.capacity_of_people = capacity_of_people;
    }

    public BigDecimal getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(BigDecimal price_per_night) {
        this.price_per_night = price_per_night;
    }
}
