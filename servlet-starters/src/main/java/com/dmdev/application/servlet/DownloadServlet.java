package com.dmdev.application.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        Files.readAllBytes(Path.of("resources", "fordownload.json")); doesn't work inside server
        try (ServletOutputStream outputStream = resp.getOutputStream();
             InputStream inputStream = DownloadServlet.class.getClassLoader().getResourceAsStream("fordownload.json");
        ) {
            outputStream.write(inputStream.readAllBytes());
        }
    }
}
