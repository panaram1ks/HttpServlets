package com.dmdev.application.servlet;

import com.dmdev.application.dto.CreateUserDto;
import com.dmdev.application.exception.ValidationException;
import com.dmdev.application.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("USER", "ADMIN"));
        req.setAttribute("genders", List.of("MALE", "FEMALE"));
        req.getRequestDispatcher(JspHelper.getPath("registration")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String gender = req.getParameter("gender");
        CreateUserDto userDto = CreateUserDto.builder()
                .name(name)
                .birthday(birthday)
                .email(email)
                .password(password)
                .role(role)
                .gender(gender)
                .build();
        try{
            userService.create(userDto);
            resp.sendRedirect("/login");
        }catch (ValidationException e){
            req.setAttribute("errors", e.getErrors());
            doGet(req,resp);
        }

    }

}
