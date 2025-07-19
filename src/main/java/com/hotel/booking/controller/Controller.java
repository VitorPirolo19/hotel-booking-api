package com.hotel.booking.controller;

import com.hotel.booking.dto.BookingDTO;
import com.hotel.booking.entity.Booking;
import com.hotel.booking.entity.Room;
import com.hotel.booking.exception.RoomException;
import com.hotel.booking.exception.RoomUnavailableException;
import com.hotel.booking.service.BookingService;
import com.hotel.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class Controller {
    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.ok().body(roomService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Room>> findRoomByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(roomService.findByID(id));
    }

    @PostMapping()
    public ResponseEntity<Room> saveRoom(@RequestBody Room room){
        return ResponseEntity.ok().body(roomService.saveRoom(room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomByID(@PathVariable Integer id){
        roomService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> saveBooking(@RequestBody BookingDTO bookingDTO){
        return ResponseEntity.ok().body(bookingService.saveBooking(bookingDTO));
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok().body(bookingService.findAll());
    }

    @GetMapping("/bookings/search")
    public ResponseEntity<List<Booking>> findBookingsByUsername(@RequestParam String username){
        return ResponseEntity.ok().body(bookingService.findByUsername(username));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAllAvailableRooms(@RequestParam LocalDateTime checkin,
                                                           @RequestParam LocalDateTime checkout){
        return ResponseEntity.ok().body(roomService.findAllAvailableRooms(checkin, checkout));
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<?> deleteBookingByID(@PathVariable Long id){
        bookingService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
