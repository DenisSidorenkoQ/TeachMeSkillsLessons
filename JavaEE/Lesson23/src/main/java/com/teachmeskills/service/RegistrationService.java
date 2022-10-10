package com.teachmeskills.service;

import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;

public class RegistrationService {
    private final UserRepository userRepository;

    public RegistrationService(UserRepository jdbcUserRepository) {
        this.userRepository = jdbcUserRepository;
    }

    public boolean registerUser(String username, String password) {
        return userRepository.insertNewUser(username, password);
    }

    public boolean findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    public void registration(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Writer writer = resp.getWriter()){
            if (findUserByName(username)) {
                writer.write("This login is already registered");
                req.getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
            } else {
                if (registerUser(username, password)) {
                    req.getServletContext().getRequestDispatcher("/authorization").forward(req, resp);
                }
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
