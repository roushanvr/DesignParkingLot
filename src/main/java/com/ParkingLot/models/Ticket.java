package com.ParkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entryTime;
    private Gate entryGate;
    private Operator operator;
    private Booth assignedBooth;
    private Vehicle vehicle;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Booth getAssignedBooth() {
        return assignedBooth;
    }

    public void setAssignedBooth(Booth assignedBooth) {
        this.assignedBooth = assignedBooth;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
