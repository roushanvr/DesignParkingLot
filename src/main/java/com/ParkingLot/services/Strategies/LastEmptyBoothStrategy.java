package com.ParkingLot.services.Strategies;

import com.ParkingLot.models.Booth;
import com.ParkingLot.models.Gate;
import com.ParkingLot.models.ParkingLot;
import com.ParkingLot.models.enums.ParkingBoothStatus;
import com.ParkingLot.models.enums.VehicleType;
import com.ParkingLot.repositories.BoothRepository;
import com.ParkingLot.repositories.ParkingLotRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LastEmptyBoothStrategy implements BoothAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;
    private BoothRepository boothRepository;
    public LastEmptyBoothStrategy(ParkingLotRepository parkingLotRepository, BoothRepository boothRepository){
        this.boothRepository=boothRepository;
        this.parkingLotRepository=parkingLotRepository;
    }
    @Override
    public Optional<Booth> assignBooth(VehicleType vehicleType, Gate gate) {
        //from the gate I will get parkingLot and from this parkingLot I will get list of
        //Booths
        ParkingLot parkingLot=parkingLotRepository.fetchByGateId(gate.getId());
        List<Booth> parkingBooths=boothRepository.fetchAllBoothByParkingLot(parkingLot.getId());

        Collections.reverse(parkingBooths);

        for(Booth booth: parkingBooths){
            if(booth.getBoothStatus().equals(ParkingBoothStatus.AVAILABLE) &&
              booth.getSupportedVehicleType().equals(vehicleType)) {
                return Optional.of(booth);
            }
        }
        return Optional.empty();
    }
}
