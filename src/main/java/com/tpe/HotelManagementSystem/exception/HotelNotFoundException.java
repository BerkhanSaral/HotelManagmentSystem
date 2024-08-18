package com.tpe.HotelManagementSystem.exception;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(String s){
        super(s);
    }
}
