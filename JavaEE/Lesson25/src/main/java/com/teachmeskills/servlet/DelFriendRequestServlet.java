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
@WebServlet(urlPatterns = "/delFriendRequest")
public class DelFriendRequestServlet extends HttpServlet {
    private FriendService friendService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int senderId = Integer.parseInt(req.getParameter("requestUserId"));
        int userID = (int) req.getServletContext().getAttribute("userId");

        if (req.getParameter("page").equals("incoming")) {
            log.info("del friend request. Id=[{}]", senderId);

            friendService.delRequest(senderId, userID);
            req.getRequestDispatcher("/incomingRequestsServlet").forward(req, resp);
        } else {
            log.info("del friend request. Id=[{}]", userID);

            friendService.delRequest(userID, senderId);
            req.getRequestDispatcher("/outgoingRequestServlet").forward(req, resp);
        }

    }
}
