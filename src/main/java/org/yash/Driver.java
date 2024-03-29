package org.yash;

public class Driver {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot("PR1234");
        Floor floor1 = new Floor(1, 10);
        Floor floor2 = new Floor(2, 10);
        parkingLot.addFloorToParkingLot(floor1);
        parkingLot.addFloorToParkingLot(floor2);

        parkingLot.addSlotToFloor(floor1, new Slot(1, VehicleType.TRUCK));
        parkingLot.addSlotToFloor(floor1, new Slot(2, VehicleType.BIKE));
        parkingLot.addSlotToFloor(floor1, new Slot(3, VehicleType.BIKE));
        parkingLot.addSlotToFloor(floor1, new Slot(4, VehicleType.CAR));
        parkingLot.addSlotToFloor(floor1, new Slot(5, VehicleType.CAR));

        parkingLot.addSlotToFloor(floor2, new Slot(6, VehicleType.TRUCK));
        parkingLot.addSlotToFloor(floor2, new Slot(7, VehicleType.BIKE));
        parkingLot.addSlotToFloor(floor2, new Slot(8, VehicleType.CAR));
        parkingLot.addSlotToFloor(floor2, new Slot(8, VehicleType.CAR));

        Vehicle vehicle1 = new Vehicle("V1", "HR20", "red", VehicleType.BIKE);
        Vehicle vehicle2 = new Vehicle("V2", "HR@0", "black", VehicleType.CAR);
        Vehicle vehicle3 = new Vehicle("V3", "HR@0", "black", VehicleType.CAR);
        Vehicle vehicle4 = new Vehicle("V4", "HR@0", "black", VehicleType.CAR);
        //Ticket ticket1 = new Ticket("PR1234", 1, 4);
        Ticket ticket1 = parkingLot.parkVehicle(vehicle1);
        Ticket ticket2 = parkingLot.parkVehicle(vehicle2);
        Ticket ticket3 = parkingLot.parkVehicle(vehicle3);
        parkingLot.unparkVehicle(ticket1);
        Ticket ticket4 = parkingLot.parkVehicle(vehicle4);

        System.out.println("--------------");
        parkingLot.displayNofFreeSlotsAvailable();
        parkingLot.displayNofFreeSlotsAvailableSpecificToVehicleType(VehicleType.CAR);

    }
}