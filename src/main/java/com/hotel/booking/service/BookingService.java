package com.hotel.booking.service;

import com.hotel.booking.entity.Booking;
import com.hotel.booking.exception.InvalidDateException;
import com.hotel.booking.exception.InvalidNumberOfPeopleException;
import com.hotel.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking){
        if (booking.getCheckin().isAfter(booking.getCheckout())){
            throw new InvalidDateException("check-in cannot be after check-out");
        } else if (booking.getRoom().getCapacity_of_people() < booking.getNumber_of_people()) {
            throw new InvalidNumberOfPeopleException("the number of people cannot be bigger than the room capacity");
        }
        return bookingRepository.save(booking);
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public List<Booking> findByUsername(String username){
        return bookingRepository.findByUsername(username);
    }

    public void deleteByID(Long id){
        bookingRepository.deleteById(id);
    }
}
