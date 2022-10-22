package com.teachmeskills.servlet;

import com.teachmeskills.model.User;
import com.teachmeskills.service.FriendService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(urlPatterns = "/incomingRequestsServlet")
public class IncomingRequestsServlet extends HttpServlet {
    private FriendService friendService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        int userId = (int) req.getServletContext().getAttribute("userId");
        List<User> listOfUsersWithIncomingRequest = friendService.getUsersOfAllIncomingRequests(userId);
        req.getServletContext().setAttribute("listOfUsersWithIncomingRequest", listOfUsersWithIncomingRequest);
        req.getRequestDispatcher("/IncomingRequests.jsp").forward(req, resp);
    }
}
