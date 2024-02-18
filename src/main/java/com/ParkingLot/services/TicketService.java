package com.ParkingLot.services;

import com.ParkingLot.exceptions.BoothNotAvailableException;
import com.ParkingLot.exceptions.GateNotFoundException;
import com.ParkingLot.models.Booth;
import com.ParkingLot.models.Gate;
import com.ParkingLot.models.Ticket;
import com.ParkingLot.models.Vehicle;
import com.ParkingLot.models.enums.VehicleType;
import com.ParkingLot.repositories.TicketRepository;
import com.ParkingLot.services.Strategies.BoothAllocationStrategy;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

public class TicketService {
    private TicketRepository ticketRepository;
    private GateService gateService;
    private VehicleService vehicleService;
    private BoothAllocationStrategy boothAllocationStrategy;
    public TicketService(TicketRepository ticketRepository, GateService gateService, VehicleService vehicleService,
                         BoothAllocationStrategy boothAllocationStrategy){
        this.ticketRepository=ticketRepository;
        this.gateService=gateService;
        this.vehicleService=vehicleService;
        this.boothAllocationStrategy=boothAllocationStrategy;
    }
    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws GateNotFoundException, BoothNotAvailableException {
    //To make this Ticket(Return Ticket) what things we need :
        //EntryTime: system.now
        //Vehicle: we have vehicleNumber and VehicleType, we can retrieve the Vehicle object
        //Gate: we have gateId. so I can get the gate object
        //Operator: we can get from Gate object
        //Booth: I will get from strategy.


        //Pseudo Algorithm:
        //get the gate object => depend upon GateService
        //get or register the vehicle => depend upon vehicleService
        //assign booth using appropriate strategy
        //save ticket object in database


        //get the gate object
        Gate gate=gateService.getGateById(gateId);

        //get or register the vehicle
        Vehicle vehicle=vehicleService.getVehicle(vehicleNumber,vehicleType);

        Optional<Booth> assignedBoothWrapper=boothAllocationStrategy.assignBooth(vehicleType,gate);
         if(assignedBoothWrapper.isEmpty()){
             throw new BoothNotAvailableException();
         }
        //create ticket object
        Ticket ticket=new Ticket();
        ticket.setEntryGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getCurrentOperator());
        ticket.setVehicle(vehicle);
        ticket.setAssignedBooth(assignedBoothWrapper.get());

        //save ticket object in db to  get the id
        Ticket savedTicket=ticketRepository.save(ticket);
        //this method will return ticket with id
        return savedTicket;
    }

}
