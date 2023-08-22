package com.dmdev.application.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("/flights").forward(req, resp);// redirect
//        req.getRequestDispatcher("/flights").include(req, resp);// include
//        getServletContext().getRequestDispatcher("/flights").forward(req, resp);
        System.out.println();

        // redict
        resp.sendRedirect("/flights");

        PrintWriter writer = resp.getWriter();
        writer.write("Hello 2");
    }
}
