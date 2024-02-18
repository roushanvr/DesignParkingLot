package com.ParkingLot.dtos;

import com.ParkingLot.models.enums.VehicleType;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long GateId;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getGateId() {
        return GateId;
    }

    public void setGateId(Long gateId) {
        GateId = gateId;
    }
}
