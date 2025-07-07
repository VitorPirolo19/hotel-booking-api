package com.hotel.booking.controller;

import com.hotel.booking.entity.Booking;
import com.hotel.booking.entity.Room;
import com.hotel.booking.service.BookingService;
import com.hotel.booking.service.RoomService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

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
}
