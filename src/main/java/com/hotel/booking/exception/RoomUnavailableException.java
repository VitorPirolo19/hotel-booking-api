package com.hotel.booking.exception;

public class RoomUnavailableException extends RuntimeException{
    public RoomUnavailableException(String msg){
        super(msg);
    }
}
