package com.teachmeskills.servlet;

import com.teachmeskills.service.UserService;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authorization")
@Log4j2
public class AuthorizationServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");
        int userId = userService.getUserIdByLogin(username);

        try (Writer writer = resp.getWriter()) {
            if (userService.isExists(username, password)) {
                log.info("User is exists. Login[{}]", username);
                req.getServletContext().setAttribute("username", username);
                req.getServletContext().setAttribute("userId", userId);
                req.getRequestDispatcher("/Output.jsp").forward(req, resp);
            } else {
                log.warn("User not exists. Login[{}]", username);
                writer.write("Authorization Error");
            }
        }
    }
}
