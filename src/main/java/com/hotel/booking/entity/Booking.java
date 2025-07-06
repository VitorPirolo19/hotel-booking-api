package com.hotel.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Room room;
    private String username;
    private Integer number_of_people;
    private LocalDateTime checkin;
    private LocalDateTime checkout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(Integer number_of_people) {
        this.number_of_people = number_of_people;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(room, booking.room) && Objects.equals(username, booking.username) && Objects.equals(number_of_people, booking.number_of_people) && Objects.equals(checkin, booking.checkin) && Objects.equals(checkout, booking.checkout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, username, number_of_people, checkin, checkout);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + room +
                ", username='" + username + '\'' +
                ", number_of_people=" + number_of_people +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                '}';
    }
}

