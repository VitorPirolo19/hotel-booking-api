package com.hotel.booking.exception;

public class InvalidDateException extends RuntimeException{

    public InvalidDateException(String msg){
        super(msg);
    }
}
