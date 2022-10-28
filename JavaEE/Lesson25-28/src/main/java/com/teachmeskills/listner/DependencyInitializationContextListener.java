package com.teachmeskills.listner;

import com.teachmeskills.repository.MessageRepository;
import com.teachmeskills.repository.JdbcMessageRepository;
import com.teachmeskills.repository.UserRepository;
import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.FriendRequestRepository;
import com.teachmeskills.repository.JdbcFriendRequestRepository;
import com.teachmeskills.repository.FriendRepository;
import com.teachmeskills.repository.JdbcFriendRepository;
import com.teachmeskills.service.FriendRequestService;
import com.teachmeskills.service.FriendService;
import com.teachmeskills.service.MessageService;
import com.teachmeskills.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String dbDriver = sce.getServletContext().getInitParameter("db_driver");
        final String username = sce.getServletContext().getInitParameter("db_user");
        final String password = sce.getServletContext().getInitParameter("db_password");
        final String dbUrl = sce.getServletContext().getInitParameter("db_url");

        try {
            Class.forName(dbDriver);
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            FriendRequestRepository friendRequestRepository = new JdbcFriendRequestRepository(connection);
            FriendRepository friendRepository = new JdbcFriendRepository(connection);
            MessageRepository messageRepository = new JdbcMessageRepository(connection);

            UserRepository userRepository = new JdbcUserRepository(connection);
            UserService userService = new UserService(userRepository);
            FriendService friendService = new FriendService(friendRequestRepository, friendRepository, messageRepository);
            FriendRequestService friendRequestService = new FriendRequestService(friendRequestRepository);
            MessageService messageService = new MessageService(messageRepository);

            sce.getServletContext().setAttribute("userService", userService);
            sce.getServletContext().setAttribute("friendService", friendService);
            sce.getServletContext().setAttribute("friendRequestService", friendRequestService);
            sce.getServletContext().setAttribute("messageService", messageService);
            System.out.println(connection.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Dependencies not created");
        }
    }
}
