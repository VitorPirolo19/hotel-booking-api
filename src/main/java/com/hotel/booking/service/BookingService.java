package com.hotel.booking.service;

import com.hotel.booking.dto.BookingDTO;
import com.hotel.booking.entity.Booking;
import com.hotel.booking.entity.Room;
import com.hotel.booking.exception.InvalidDateException;
import com.hotel.booking.exception.InvalidNumberOfPeopleException;
import com.hotel.booking.exception.RoomException;
import com.hotel.booking.exception.RoomUnavailableException;
import com.hotel.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomService roomService;

    public Booking saveBooking(BookingDTO bookingDTO){
        Room room = roomService.findRoomByID(bookingDTO.getRoomNumber()).orElseThrow(() -> new RoomException("Room not found"));

        validateBookingData(bookingDTO, room);

        if (roomService.isAvailable(bookingDTO.getCheckin(), bookingDTO.getCheckout(),bookingDTO.getRoomNumber())){
            Booking booking = new Booking();
            booking.setRoom(room);
            booking.setUsername(bookingDTO.getUsername());
            booking.setNumber_of_people(bookingDTO.getNumberOfPeople());
            booking.setCheckin(bookingDTO.getCheckin());
            booking.setCheckout(bookingDTO.getCheckout());
            booking.setPrice(calculatePrice(bookingDTO, room));
            return bookingRepository.save(booking);
        }else{
            throw new RoomUnavailableException("Room is not available in the selected date range");
        }
    }

    public List<Booking> findBooking(String username, Integer roomNumber){
        if (username != null){
            return bookingRepository.findByUsername(username);
        }
       if (roomNumber != null){
           return bookingRepository.findByRoomNumber(roomNumber);
       }
       return bookingRepository.findAll();
    }


    public void deleteBookingByID(Long id){
        bookingRepository.deleteById(id);
    }

    private void validateBookingData(BookingDTO dto, Room room){
        if (dto.getCheckin().isAfter(dto.getCheckout())){
            throw new InvalidDateException("check-in cannot be after check-out");
        }
        if (dto.getCheckin().isBefore(LocalDateTime.now())){
            throw new InvalidDateException("check-in cannot be in the past");
        }
        if (room.getCapacity_of_people() < dto.getNumberOfPeople()) {
            throw new InvalidNumberOfPeopleException("the number of people cannot be bigger than the room capacity");
        }
    }
    private BigDecimal calculatePrice(BookingDTO bookingDTO, Room room){
        BigDecimal numberOfDays = BigDecimal.valueOf(ChronoUnit.DAYS.between(bookingDTO.getCheckin(), bookingDTO.getCheckout()));
        BigDecimal price = numberOfDays.multiply(room.getPrice_per_night());
        return price;
    }
}
