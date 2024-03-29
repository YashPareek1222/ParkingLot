package org.yash;

public class Ticket {

    private String parkingLotId;
    private int floorNumber;
    private int slotNo;
    public Ticket(String id, int floorNumber, int slotNo) {
        this.parkingLotId = id;
        this.floorNumber = floorNumber;
        this.slotNo = slotNo;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNo() {
        return slotNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "parkingLotId=" + parkingLotId +
                ", floorNumber=" + floorNumber +
                ", slotNo=" + slotNo +
                '}';
    }
}
