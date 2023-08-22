package com.dmdev.application.servlet;

import com.dmdev.application.dto.FlightDto;
import com.dmdev.application.service.FlightService;
import com.dmdev.application.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDto> flightDto = flightService.findAll();
        req.setAttribute("flights", flightDto);
        req.getSession().setAttribute("flightsMap", flightDto.stream().collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));

        // path starts from "webapp folder"
        req.getRequestDispatcher(JspHelper.getPath("content")).forward(req, resp);
    }
}
