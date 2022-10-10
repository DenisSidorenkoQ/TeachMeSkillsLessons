package com.teachmeskills.listner;

import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.UserRepository;
import com.teachmeskills.service.OutputService;
import com.teachmeskills.service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String DB_DRIVER = "org.postgresql.Driver";
        final String USERNAME = "postgres";
        final String PASSWORD = "postgres";
        final String DB_URL = "jdbc:postgresql://postgres:5432/postgres";

        try {
            Class.forName(DB_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            UserRepository userRepository = new JdbcUserRepository(connection);
            OutputService outputService = new OutputService(userRepository);
            UserService userService = new UserService(userRepository);

            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("jdbcUserRepository", userRepository);
            sce.getServletContext().setAttribute("outputService", outputService);
            sce.getServletContext().setAttribute("userService", userService);
            System.out.println(connection.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
