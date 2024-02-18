package com.ParkingLot.repositories;

import com.ParkingLot.models.Ticket;
import com.ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    private HashMap<Long, Vehicle> vehicleTableMock=new HashMap<>();
    private Long autoIncrementIdMock = 0L;
    public Vehicle save(Vehicle vehicle){
        if(vehicle.getId()==null){
            autoIncrementIdMock++;
            vehicle.setId(autoIncrementIdMock);//set the id in vehicle
            vehicleTableMock.put(autoIncrementIdMock,vehicle);
        }
        else{
            vehicleTableMock.put(vehicle.getId(), vehicle);
        }
        return vehicle;
    }

    public Optional<Vehicle> fetchVehicleByNumber(String vehicleNumber){
       for(Vehicle vehicle:vehicleTableMock.values()){
           if(vehicle.getVehicleNumber().equals(vehicleNumber)){
               return Optional.of(vehicle);
           }
       }
       return Optional.empty();
    }
}
