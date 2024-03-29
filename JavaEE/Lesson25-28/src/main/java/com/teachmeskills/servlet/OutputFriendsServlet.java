package com.teachmeskills.servlet;

import com.teachmeskills.model.User;
import com.teachmeskills.service.user.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/friends")
public class OutputFriendsServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");

        List<User> friendsList = userService.getAllFriends(userId);
        req.getServletContext().setAttribute("friendsList", friendsList);
        req.getRequestDispatcher("/Friends.jsp").forward(req, resp);
    }
}
