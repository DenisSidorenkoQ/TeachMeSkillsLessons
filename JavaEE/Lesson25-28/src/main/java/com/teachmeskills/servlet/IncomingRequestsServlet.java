package com.teachmeskills.servlet;

import com.teachmeskills.model.User;
import com.teachmeskills.service.FriendRequestService;
import com.teachmeskills.service.user.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(urlPatterns = "/incomingRequests")
public class IncomingRequestsServlet extends HttpServlet {
    private UserService userService;
    private FriendRequestService friendRequestService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
        friendRequestService = (FriendRequestService) config.getServletContext().getAttribute("friendRequestService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        List<User> listOfUsersWithIncomingRequest = userService.getUsersOfAllIncomingRequests(userId);

        req.getServletContext().setAttribute("listOfUsersWithIncomingRequest", listOfUsersWithIncomingRequest);
        req.getRequestDispatcher("/IncomingRequests.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int senderId = Integer.parseInt(req.getParameter("requestUserId"));
        int userID = (int) req.getSession().getAttribute("userId");

        log.info("del friend request. Id=[{}]", senderId);
        friendRequestService.delRequest(senderId, userID);
        doGet(req, resp);
    }
}
