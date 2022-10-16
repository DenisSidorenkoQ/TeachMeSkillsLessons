package com.teachmeskills.servlet;

import com.teachmeskills.service.UserService;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
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
            req.getServletContext().getRequestDispatcher("/authorization").forward(req, resp);
        } else {
            req.getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
        }

    }
}
