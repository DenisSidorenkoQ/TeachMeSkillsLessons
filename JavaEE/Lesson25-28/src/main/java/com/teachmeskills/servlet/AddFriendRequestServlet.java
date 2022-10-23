package com.teachmeskills.servlet;

import com.teachmeskills.service.FriendRequestService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/friendRequest")
public class AddFriendRequestServlet extends HttpServlet {
    private FriendRequestService friendRequestService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        friendRequestService = (FriendRequestService) config.getServletContext().getAttribute("friendRequestService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        int recipientId = Integer.parseInt(req.getParameter("requestFriendId"));

        if (friendRequestService.friendRequestIsExists(userId, recipientId)) {
            log.info("Request is exists. Id=[{}]", recipientId);
        } else {
            friendRequestService.createRequest(userId, recipientId);
            log.info(
                    "Request not exists. Create new request senderId=[{}] recipientId=[{}]",
                    userId,
                    recipientId
            );
        }
        req.getServletContext().getRequestDispatcher("/Users.jsp").forward(req, resp);
    }
}
