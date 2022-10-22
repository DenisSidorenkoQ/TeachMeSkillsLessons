package com.teachmeskills.servlet;

import com.teachmeskills.service.FriendService;
import com.teachmeskills.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/outputFriends")
public class OutputFriendsServlet extends HttpServlet {

    private FriendService friendService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getServletContext().getAttribute("userId");

    }
}
