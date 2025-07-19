package com.hotel.booking.service;

import com.hotel.booking.dto.RoomDTO;
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

    public Room saveRoom(RoomDTO roomDTO){
        Room room = new Room();
        room.setNumber(roomDTO.getNumber());
        room.setRoom_type(roomDTO.getRoom_type());
        room.setDescription(roomDTO.getDescription());
        room.setCapacity_of_people(roomDTO.getCapacity_of_people());
        room.setPrice_per_night(roomDTO.getPrice_per_night());
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
