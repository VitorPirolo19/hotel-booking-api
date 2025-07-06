package com.hotel.booking.entity;

import com.hotel.booking.enums.RoomTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name="rooms")
public class Room {

    @Id
    private Integer number;
    private RoomTypes roomType;
    private String description;
    private Integer capacity_of_people;
    private BigDecimal price_per_night;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public RoomTypes getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypes roomType) {
        this.roomType = roomType;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(number, room.number) && roomType == room.roomType && Objects.equals(description, room.description) && Objects.equals(capacity_of_people, room.capacity_of_people) && Objects.equals(price_per_night, room.price_per_night);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, roomType, description, capacity_of_people, price_per_night);
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", roomType=" + roomType +
                ", description='" + description + '\'' +
                ", capacity_of_people=" + capacity_of_people +
                ", price_per_night=" + price_per_night +
                '}';
    }
}
