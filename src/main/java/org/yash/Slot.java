package org.yash;

public class Slot {

    private int slotNo;
    private VehicleType vehicleType;
    private Boolean slotOccupied;

    public Slot(int slotNo, VehicleType vehicleType) {
        this.slotNo = slotNo;
        this.vehicleType = vehicleType;
        this.slotOccupied = false;
    }

    public Boolean occupySlot(Vehicle vehicle) {
        if (vehicle.getVehicleType().equals(vehicleType) && !slotOccupied) {
            slotOccupied = true;
            return true;
        }
        return false;
    }

    public void unoccupySlot() {
        slotOccupied = false;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Boolean getSlotOccupied() {
        return slotOccupied;
    }

    public int getSlotNo() {
        return slotNo;
    }
}
