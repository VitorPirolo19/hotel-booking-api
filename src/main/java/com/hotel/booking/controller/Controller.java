package com.hotel.booking.controller;

import com.hotel.booking.entity.Booking;
import com.hotel.booking.entity.Room;
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
@RequestMapping("/room")
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

    @PostMapping("/booking")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){
        return ResponseEntity.ok().body(bookingService.saveBooking(booking));
    }

    @GetMapping("/booking")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok().body(bookingService.findAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAllAvailableRooms(@RequestParam LocalDateTime checkin,
                                                           @RequestParam LocalDateTime checkout){
        return ResponseEntity.ok().body(roomService.findAllAvailableRooms(checkin, checkout));
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<?> deleteBookingByID(@PathVariable Long id){
        bookingService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
