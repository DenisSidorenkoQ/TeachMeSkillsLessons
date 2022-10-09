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

    private Connection connection;
    private AuthenticationService authenticationService;
    private RegistrationService registrationService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = (Connection) config.getServletContext().getAttribute("connection");
        authenticationService = new AuthenticationService(connection);
        registrationService = new RegistrationService(connection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (Writer writer = resp.getWriter()){
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (registrationService.findUserByName(username)) {
                writer.write("This login is already registered");
                getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
            } else {
                if (registrationService.registerUser(username, password)) {
                    getServletContext().getRequestDispatcher("/authorization").forward(req, resp);
                }
            }

        }
    }
}
