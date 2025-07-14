package com.hotel.booking.exception;

public class InvalidNumberOfPeopleException extends RuntimeException {
    public InvalidNumberOfPeopleException(String msg){
        super(msg);
    }
}
