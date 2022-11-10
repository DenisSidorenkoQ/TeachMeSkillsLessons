package com.teachmeskills.servlet;

import com.teachmeskills.service.user.UserService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
@Slf4j
public class RegistrationServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");

        if (userService.register(username, password)) {
            log.info("User does not exist, registering a new user. Login[{}]", username);
            req.getServletContext().getRequestDispatcher("/authorization").forward(req, resp);
        } else {
            log.info("User is already to exist. Login[{}]", username);
            req.getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
        }

    }
}
