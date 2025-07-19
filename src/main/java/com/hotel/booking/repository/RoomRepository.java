package com.hotel.booking.repository;

import com.hotel.booking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

    @Query("""
        SELECT r FROM rooms r
        WHERE NOT EXISTS (
            SELECT 1 FROM bookings b
            WHERE b.room.number = r.number
              AND b.checkin < :checkout
              AND b.checkout > :checkin
        )
        """)
    List<Room> findAvailableRooms(@Param("checkin") LocalDateTime checkin,
                                  @Param("checkout") LocalDateTime checkout);
    @Query("""
            SELECT r FROM rooms r
            WHERE NOT EXISTS (
            SELECT 1 FROM bookings b
            WHERE b.room.number = r.number
              AND b.checkin < :checkout
              AND b.checkout > :checkin
            )
            AND number = :number
            """)
    Room isAvailable(@Param("checkin") LocalDateTime checkin,
                     @Param("checkout") LocalDateTime checkout,
                     @Param("number") Integer number);
}
