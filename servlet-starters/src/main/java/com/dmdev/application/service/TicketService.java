package com.dmdev.application.service;

import com.dmdev.application.dao.TicketDao;
import com.dmdev.application.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream().map(ticket ->
                TicketDto.builder().id(ticket.getId()).flightId(ticket.getFlightId()).seatNo(ticket.getSeatNo()).build()
        ).collect(Collectors.toList());
    }

    private TicketService() {
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
