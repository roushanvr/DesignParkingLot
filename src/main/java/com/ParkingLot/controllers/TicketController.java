package com.ParkingLot.controllers;

import com.ParkingLot.dtos.GenerateTicketRequestDto;
import com.ParkingLot.dtos.GenerateTicketResponseDto;
import com.ParkingLot.dtos.ResponseStatus;
import com.ParkingLot.models.Ticket;
import com.ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

   public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto=new GenerateTicketResponseDto();

       try{
           //Ticket ticket=ticketService.generateTicket(requestDto);
           //can we send the same Dto to service layer also?
           //Ans: yes we can, but we don't send because one service layer might be used by
           //different controllers and every controller have their own requestDto.
           //If we make our service layer to accept requestDto, it will be tightly
           //bound to a specific controller and what if multiple controllers wants to use the same
           //service.
           //we generally convert Dto to model and then send the model: will see in project module
           Ticket ticket=ticketService.generateTicket(requestDto.getGateId(),
                   requestDto.getVehicleNumber(),
                   requestDto.getVehicleType());

           responseDto.setGeneratedTicketId(ticket.getId());
           responseDto.setResponse(ResponseStatus.SUCCESS);
           responseDto.setMessage("Ticket generated successfully");
       }
       catch(Exception ex){
          responseDto.setResponse(ResponseStatus.FAILURE);
          responseDto.setMessage("something wrong happened");
       }
       return responseDto;
   }

}
