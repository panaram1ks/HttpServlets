package com.dmdev.application.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketDto {
    Long id;
    Long flightId;
    String seatNo;
}
