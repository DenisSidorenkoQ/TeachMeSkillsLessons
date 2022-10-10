package com.teachmeskills.service;

import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;

public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userIsExists(String username, String password) {
        return userRepository.userIsExists(username, password);
    }

    public boolean findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    public void authentication(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try (Writer writer = resp.getWriter()){
            if (userIsExists(username, password)) {
                req.getServletContext().setAttribute("username", username);
                req.getRequestDispatcher("/Output.jsp").forward(req, resp);
            } else {
                writer.write("Authorization Error");
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
