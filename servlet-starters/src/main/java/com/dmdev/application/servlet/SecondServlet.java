package com.dmdev.application.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        // Global common object for any servlet !
        ServletContext servletContext = config.getServletContext();
        super.init(config);
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //method GET
        String param = req.getParameter("param");
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println();

//        String header = req.getHeader("user-agent");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(req.getHeader(headerName));
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12345");
        //second variant
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("Hello from second servlet. Привет! Меня зовут сервлет");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
