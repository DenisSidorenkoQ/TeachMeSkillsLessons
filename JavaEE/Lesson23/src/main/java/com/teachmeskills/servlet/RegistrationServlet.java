package com.teachmeskills.servlet;

import com.teachmeskills.service.AuthenticationService;
import com.teachmeskills.service.RegistrationService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RegistrationService registrationService =
                (RegistrationService) req.getServletContext().getAttribute("registrationService");

        registrationService.registration(req, resp);
    }
}
