package com.ParkingLot.services;

import com.ParkingLot.exceptions.GateNotFoundException;
import com.ParkingLot.models.Gate;
import com.ParkingLot.repositories.GateRepository;

import java.util.Optional;

public class GateService {
 private GateRepository gateRepository;
   public GateService(GateRepository gateRepository){
      this.gateRepository=gateRepository;
   }
   public Gate getGateById(Long gateid) throws GateNotFoundException{
       Optional<Gate> gateWrapper=gateRepository.fetchGateById(gateid);
       if(gateWrapper.isPresent()){
           return gateWrapper.get();
       }
       else{
           throw new GateNotFoundException();
       }
   }
   //Difference between GateService and VehicleService here is GateService just throws the
    //exception if it does not find gate with given gateId
    //whereas vehicleService just register the vehicle if it does not find vehicle
 }
