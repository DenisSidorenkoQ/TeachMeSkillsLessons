package com.teachmeskills.servlet;

import com.teachmeskills.service.FriendService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/friend")
public class AddFriendServlet extends HttpServlet {
    private FriendService friendService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        int recipientId = Integer.parseInt(req.getParameter("requestUserId"));

        friendService.addFriend(recipientId, userId);
        log.info("Add new friend. Id=[{}]", recipientId);
        req.getServletContext().getRequestDispatcher("/incomingRequests").forward(req, resp);
    }
}
