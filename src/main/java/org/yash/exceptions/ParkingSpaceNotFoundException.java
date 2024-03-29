package org.yash.exceptions;

public class ParkingSpaceNotFoundException extends RuntimeException{
    public ParkingSpaceNotFoundException(String message) {
        super(message);
    }
}
