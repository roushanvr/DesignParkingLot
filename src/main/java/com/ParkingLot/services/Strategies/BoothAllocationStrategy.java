package com.ParkingLot.services.Strategies;

import com.ParkingLot.models.Booth;
import com.ParkingLot.models.Gate;
import com.ParkingLot.models.enums.VehicleType;

import java.util.Optional;

public interface BoothAllocationStrategy {
    //input it will take is vehicle type and from which gate you are entering
    Optional<Booth> assignBooth(VehicleType vehicleType, Gate gate);
}
