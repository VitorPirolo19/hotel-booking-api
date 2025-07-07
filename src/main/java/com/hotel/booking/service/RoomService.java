package com.hotel.booking.service;

import com.hotel.booking.entity.Room;
import com.hotel.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
