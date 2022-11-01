package com.teachmeskills.servlet;


import com.teachmeskills.model.User;
import com.teachmeskills.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/output")
public class OutputServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("par");
        List<User> users = userService.getAllUsers(param);

        req.getServletContext().setAttribute("users", users);
        req.getRequestDispatcher("/Users.jsp").forward(req, resp);
    }
}
