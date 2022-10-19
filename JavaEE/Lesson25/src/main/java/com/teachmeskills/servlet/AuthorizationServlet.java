package com.teachmeskills.servlet;

import com.teachmeskills.service.UserService;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");

        try (Writer writer = resp.getWriter()) {
            if (userService.isExists(username, password)) {
                req.getServletContext().setAttribute("username", username);
                req.getRequestDispatcher("/Output.jsp").forward(req, resp);
            } else {
                writer.write("Authorization Error");
            }
        }
    }
}
