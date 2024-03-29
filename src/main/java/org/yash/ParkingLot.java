package org.yash;

import org.yash.exceptions.ParkingSpaceNotFoundException;
import org.yash.exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String id;
    private List<Floor> floors;

    public ParkingLot(String id) {
        this.id = id;
        this.floors = new ArrayList<>();
    }

    public void addFloorToParkingLot(Floor floor) {
        floors.add(floor);
    }

    public void addSlotToFloor(Floor floor, Slot slot) {
        floor.addSlotToFloor(slot);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            try {
                int slotNo = floor.parkVehicleOnFloor(vehicle);
                System.out.println("Vehicle parked successfully on floor : " + floor.getFloorNumber()
                        + " and slotNo : " + slotNo);
                return new Ticket(id, floor.getFloorNumber(), slotNo);
            }
            catch (ParkingSpaceNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        throw new ParkingSpaceNotFoundException("No Parking Space Available");
    }

    public void displayNofFreeSlotsAvailable() {
        for (Floor floor : floors) {
            int count = floor.numberOfFreeSlotsAvailable();
            System.out.println("No of free slots available at floor : " + floor.getFloorNumber() + " is " + count);
        }
    }

    public void displayNofFreeSlotsAvailableSpecificToVehicleType(VehicleType vehicleType) {
        for (Floor floor : floors) {
            int count = floor.numberOfFreeSlotsAvailableForVehicleType(vehicleType);
            System.out.println("No of free slots available at floor: " + floor.getFloorNumber()
                    + "for " + vehicleType + " is " + count);
        }
    }

    public void unparkVehicle(Ticket ticket) {
        for (Floor floor : floors) {
            if (floor.getFloorNumber() == ticket.getFloorNumber()) {
                try {
                    floor.unparkVehicle(ticket.getSlotNo());
                } catch (VehicleNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
