package com.teachmeskills.servlet;

import com.teachmeskills.service.user.UserService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/authorization")
@Slf4j
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
                req.getSession().setAttribute("username", username);
                req.getSession().setAttribute("userId", userId);
                resp.sendRedirect(req.getContextPath() + "/Users.jsp");
            } else {
                log.warn("User not exists. Login[{}]", username);
                writer.write("Authorization Error");
            }
        }
    }
}
