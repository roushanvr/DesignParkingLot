package com.ParkingLot.repositories;

import com.ParkingLot.models.Gate;
import com.ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    private HashMap<Long, Gate> gateTableMock=new HashMap<>();

    public Optional<Gate> fetchGateById(Long gateId){
        //hit the db to get the gate
        if(gateTableMock.containsKey(gateId)){
            return Optional.of(gateTableMock.get(gateId));
        }
        return Optional.empty();
    }
}
