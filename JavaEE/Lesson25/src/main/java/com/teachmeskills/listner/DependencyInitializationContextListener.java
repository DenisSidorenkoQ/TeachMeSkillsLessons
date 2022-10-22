package com.teachmeskills.listner;

import com.teachmeskills.repository.FriendRequestRepository;
import com.teachmeskills.repository.JdbcFriendRequestRepository;
import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.UserRepository;
import com.teachmeskills.service.FriendService;
import com.teachmeskills.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {
    static final String DB_DRIVER = "org.postgresql.Driver";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgres";
    static final String DB_URL = "jdbc:postgresql://postgres:5432/social_network";
    // "jdbc:postgresql://postgres:5432/social_network"

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Class.forName(DB_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            UserRepository userRepository = new JdbcUserRepository(connection);
            UserService userService = new UserService(userRepository);
            FriendRequestRepository friendRequestRepository = new JdbcFriendRequestRepository(connection);
            FriendService friendService = new FriendService(friendRequestRepository);

            sce.getServletContext().setAttribute("userService", userService);
            sce.getServletContext().setAttribute("friendService", friendService);
            System.out.println(connection.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Dependencies not created");
        }
    }
}
