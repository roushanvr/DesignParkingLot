package com.ParkingLot;

import com.ParkingLot.controllers.TicketController;
import com.ParkingLot.dtos.GenerateTicketRequestDto;
import com.ParkingLot.dtos.GenerateTicketResponseDto;
import com.ParkingLot.dtos.ResponseStatus;
import com.ParkingLot.models.enums.VehicleType;
import com.ParkingLot.repositories.*;
import com.ParkingLot.services.GateService;
import com.ParkingLot.services.Strategies.BoothAllocationStrategy;
import com.ParkingLot.services.Strategies.FirstEmptyBoothStrategy;
import com.ParkingLot.services.TicketService;
import com.ParkingLot.services.VehicleService;

public class Client {
    public static void main(String[] args) {
      //generate a ticket on entry gate
        //Before you make object of TicketController you have to make object  of ticket
        //service because TicketController depends on TicketService.



        VehicleRepository vr=new VehicleRepository();
        VehicleService vs=new VehicleService(vr);
        GateRepository gr=new GateRepository();
        GateService gs=new GateService(gr);
        TicketRepository tr=new TicketRepository();

        ParkingLotRepository pr=new ParkingLotRepository();
        BoothRepository br=new BoothRepository();
        BoothAllocationStrategy boothAllocationStrategy=new FirstEmptyBoothStrategy(pr,br);
        TicketService ts=new TicketService(tr,gs,vs,boothAllocationStrategy);
        TicketController tc=new TicketController(ts);

        GenerateTicketRequestDto ticketRequestDto=new GenerateTicketRequestDto();
        ticketRequestDto.setVehicleType(VehicleType.MEDIUM);
        ticketRequestDto.setVehicleNumber("HR123");
        ticketRequestDto.setGateId(10L);

        GenerateTicketResponseDto ticketResponseDto= tc.generateTicket(ticketRequestDto);

        if(ticketResponseDto.getResponse().equals(ResponseStatus.FAILURE)){
            System.out.println(ticketResponseDto.getMessage());
        }
        else{
            System.out.println("Ticket generated successfully with id" + ticketResponseDto.getGeneratedTicketId());
        }
    }
}
