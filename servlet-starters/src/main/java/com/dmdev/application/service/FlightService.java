package com.dmdev.application.service;

import com.dmdev.application.dao.FlightDao;
import com.dmdev.application.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream().map(flight -> new FlightDto(
                flight.getId(),
                """
                         %s - %s - %s
                        """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus())
        )).collect(Collectors.toList());
    }


    public static FlightService getInstance() {
        return INSTANCE;
    }
}