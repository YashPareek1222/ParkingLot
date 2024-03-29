package org.yash;

public class Vehicle {

    private String id;
    private String registrationNumber;
    private String color;
    private VehicleType vehicleType;

    public Vehicle(String id, String registrationNumber, String color, VehicleType vehicleType) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
