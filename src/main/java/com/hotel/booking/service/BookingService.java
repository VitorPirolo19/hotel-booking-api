package com.hotel.booking.service;

import com.hotel.booking.entity.Booking;
import com.hotel.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking){
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
