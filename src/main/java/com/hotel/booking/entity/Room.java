package com.hotel.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hotel.booking.enums.RoomTypes;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity(name="rooms")
public class Room {

    @Id
    private Integer number;
    @Enumerated(EnumType.STRING)
    private RoomTypes room_type;
    private String description;
    private Integer capacity_of_people;
    private BigDecimal price_per_night;
    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Booking> bookings;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(number, room.number) && room_type == room.room_type && Objects.equals(description, room.description) && Objects.equals(capacity_of_people, room.capacity_of_people) && Objects.equals(price_per_night, room.price_per_night) && Objects.equals(bookings, room.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, room_type, description, capacity_of_people, price_per_night, bookings);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

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

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", room_type=" + room_type +
                ", description='" + description + '\'' +
                ", capacity_of_people=" + capacity_of_people +
                ", price_per_night=" + price_per_night +
                ", bookings=" + bookings +
                '}';
    }
}
