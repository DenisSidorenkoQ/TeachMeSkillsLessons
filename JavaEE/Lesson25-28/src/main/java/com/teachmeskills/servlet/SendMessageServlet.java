package com.teachmeskills.servlet;

import com.teachmeskills.service.MessageService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/sendMessage")
public class SendMessageServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        messageService = (MessageService) config.getServletContext().getAttribute("messageService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        int friendId = (int) req.getSession().getAttribute("friendId");
        String message = req.getParameter("message");

        messageService.sendMessage(userId, friendId, message);
        req.getRequestDispatcher("/chat").forward(req, resp);
    }
}
