package com.hotel.booking.service;

import com.hotel.booking.entity.Room;
import com.hotel.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Optional<Room> findByID(Integer id){
        return roomRepository.findById(id);
    }

    public List<Room> findAllAvailableRooms(LocalDateTime checkin, LocalDateTime checkout){
        return roomRepository.findAvailableRooms(checkin, checkout);
    }

    public void deleteByID(Integer id){
        roomRepository.deleteById(id);
    }

    public Boolean isAvailable(LocalDateTime checkin, LocalDateTime checkout, Integer number){
        return roomRepository.isAvailable(checkin,checkout,number) != null;
    }
}
