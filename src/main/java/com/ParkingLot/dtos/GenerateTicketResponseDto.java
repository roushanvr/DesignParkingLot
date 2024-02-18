package com.ParkingLot.dtos;

public class GenerateTicketResponseDto {
    private Long generatedTicketId;
    private ResponseStatus response;
    private String message;

    public Long getGeneratedTicketId() {
        return generatedTicketId;
    }

    public void setGeneratedTicketId(Long generatedTicketId) {
        this.generatedTicketId = generatedTicketId;
    }

    public ResponseStatus getResponse() {
        return response;
    }

    public void setResponse(ResponseStatus response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
