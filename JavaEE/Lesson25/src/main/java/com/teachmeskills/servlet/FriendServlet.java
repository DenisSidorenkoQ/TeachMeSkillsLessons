package com.teachmeskills.servlet;

import com.teachmeskills.service.FriendService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(urlPatterns = "/addFriend")
public class FriendServlet extends HttpServlet {
    private FriendService friendService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        int userId = (int) req.getServletContext().getAttribute("userId");
        int recipientId = Integer.parseInt(req.getParameter("requestFriendId"));
        if (friendService.friendRequestIsExists(userId, recipientId)) {
            log.info("Request is exists");
        } else {
            friendService.createRequest(userId, recipientId);
            log.info("Request not exists. Create new request");
        }
    }

}
