package com.hotel.booking.controller;

import com.hotel.booking.dto.BookingDTO;
import com.hotel.booking.dto.RoomDTO;
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
@RequestMapping("/rooms")
public class Controller {
    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.ok().body(roomService.findAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Room>> getRoom(@PathVariable Integer id){
        return ResponseEntity.ok().body(roomService.findRoomByID(id));
    }

    @PostMapping()
    public ResponseEntity<Room> createRoom(@RequestBody RoomDTO roomDTO){
        return ResponseEntity.ok().body(roomService.saveRoom(roomDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Integer id){
        roomService.deleteRoomByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO){
        return ResponseEntity.ok().body(bookingService.saveBooking(bookingDTO));
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getBookings(
            @RequestParam(required=false) String username,
            @RequestParam(required=false) Integer room_number
            ){
        return ResponseEntity.ok().body(bookingService.findBooking(username,room_number));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAllAvailableRooms(@RequestParam LocalDateTime checkin,
                                                           @RequestParam LocalDateTime checkout){
        return ResponseEntity.ok().body(roomService.findAllAvailableRooms(checkin, checkout));
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id){
        bookingService.deleteBookingByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
