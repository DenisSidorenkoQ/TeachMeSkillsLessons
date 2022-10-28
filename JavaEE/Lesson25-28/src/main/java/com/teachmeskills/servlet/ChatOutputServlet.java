package com.teachmeskills.servlet;

import com.teachmeskills.model.Message;
import com.teachmeskills.service.MessageService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chat")
@Slf4j
public class ChatOutputServlet extends HttpServlet {
    private MessageService messageService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        messageService = (MessageService) config.getServletContext().getAttribute("messageService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        int friendId = (int) req.getSession().getAttribute("friendId");

        List<Message> messageList = messageService.getMessages(userId, friendId);
        req.getSession().setAttribute("friendId", friendId);
        req.getSession().setAttribute("messageList", messageList);
        req.getRequestDispatcher("/Chat.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int) req.getSession().getAttribute("userId");
        int friendId = Integer.parseInt(req.getParameter("friendId"));
        String friendName = req.getParameter("friendName");

        List<Message> messageList = messageService.getMessages(userId, friendId);
        req.getSession().setAttribute("friendName", friendName);
        req.getSession().setAttribute("friendId", friendId);
        req.getSession().setAttribute("messageList", messageList);
        req.getRequestDispatcher("/Chat.jsp").forward(req, resp);
    }

}
