package com.ParkingLot.models;

import com.ParkingLot.models.enums.VehicleType;

public class Vehicle extends BaseModel{
    private String VehicleNumber;
    private VehicleType vehicleType;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
