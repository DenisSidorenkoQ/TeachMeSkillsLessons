package com.teachmeskills.servlet;

import com.teachmeskills.model.User;
import com.teachmeskills.service.FriendService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/outputFriends")
public class OutputFriendsServlet extends HttpServlet {

    private FriendService friendService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getServletContext().getAttribute("userId");

        List<User> friendsList = friendService.getAllFriends(userId);
        req.getServletContext().setAttribute("friendsList", friendsList);
        req.getRequestDispatcher("/Friends.jsp").forward(req, resp);
    }
}
