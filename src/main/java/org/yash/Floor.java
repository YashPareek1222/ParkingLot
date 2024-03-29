package org.yash;

import org.yash.exceptions.FloorCapacityFullException;
import org.yash.exceptions.ParkingSpaceNotFoundException;
import org.yash.exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private int floorNumber;
    private List<Slot> slots;
    private int capacity;

    public Floor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.slots = new ArrayList<>();
    }

    public void addSlotToFloor(Slot slot) {
        if (capacity > 0) {
            slots.add(slot);
            capacity--;
            System.out.println("SlotNo : " + slot.getSlotNo() + "  added to Floor" + floorNumber);
        }
        else {
            throw new FloorCapacityFullException("More slots can't be added, capacity is full");
        }
    }

    public int numberOfFreeSlotsAvailable() {
        int count =  0;
        for (Slot slot : slots) {
            if (!slot.getSlotOccupied()) {
                count++;
            }
        }
        return count;
    }

    public int numberOfFreeSlotsAvailableForVehicleType(VehicleType vehicleType) {
        int count =  0;
        for (Slot slot : slots) {
            if (vehicleType.equals(slot.getVehicleType()) && !slot.getSlotOccupied()) {
                count++;
            }
        }
        return count;
    }

    public int parkVehicleOnFloor(Vehicle vehicle) throws ParkingSpaceNotFoundException {
        for (Slot slot : slots) {
            if (slot.occupySlot(vehicle)) {
                return slot.getSlotNo();
            }
        }
        throw new  ParkingSpaceNotFoundException("All Slots are occupied");
    }

    public void unparkVehicle(int slotNumber) {
        boolean slotFound = false;
        for (Slot slot : slots) {
            if (slotNumber == slot.getSlotNo()) {
                slot.unoccupySlot();
                slotFound = true;
                System.out.println("Vehicle is successfully unparked");
                break;
            }
        }
        if (!slotFound) {
            throw new VehicleNotFoundException("Vehicle you are trying to unpark is not parked in parkingLot");
        }
    }



    public int getFloorNumber() {
        return floorNumber;
    }

}
