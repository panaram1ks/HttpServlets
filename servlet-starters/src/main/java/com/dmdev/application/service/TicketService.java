package com.dmdev.application.service;

import com.dmdev.application.dto.TicketDto;

import java.util.List;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    public List<TicketDto>

    private TicketService() {
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
