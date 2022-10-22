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
@WebServlet(urlPatterns = "/outgoingRequestServlet")
public class OutgoingRequestServlet extends HttpServlet {
    private FriendService friendService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        friendService = (FriendService) config.getServletContext().getAttribute("friendService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getServletContext().getAttribute("userId");
        List<User> listOfUsersWithOutgoingRequest = friendService.getUsersOfAllOutgoingRequests(userId);

        req.getServletContext().setAttribute("listOfUsersWithOutgoingRequest", listOfUsersWithOutgoingRequest);
        req.getRequestDispatcher("/OutgoingRequests.jsp").forward(req, resp);
    }
}
