package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.getCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public ParkingTicket park(Car car) {
        isParkingLotFull(car);
        return parkingLot.addCar(car);
    }

    private void isValidTicket(ParkingTicket ticket){
        this.lastErrorMessage = parkingLot.isValidTicket(ticket) == true ?
                "Please provide your parking ticket." :
                        "Unrecognized parking ticket.";
    }

    private void isParkingLotFull(Car car){
        this.lastErrorMessage = parkingLot.isParkingPositionFull(car) == true? "Not enough position." : null;
    }



}
