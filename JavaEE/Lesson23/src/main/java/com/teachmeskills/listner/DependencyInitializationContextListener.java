package com.teachmeskills.listner;

import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.UserRepository;
import com.teachmeskills.service.AuthenticationService;
import com.teachmeskills.service.OutputService;
import com.teachmeskills.service.RegistrationService;

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
            UserRepository UserRepository = new JdbcUserRepository(connection);
            AuthenticationService authenticationService = new AuthenticationService(UserRepository);
            RegistrationService registrationService = new RegistrationService(UserRepository);
            OutputService outputService = new OutputService(UserRepository);

            sce.getServletContext().setAttribute("connection", connection);
            sce.getServletContext().setAttribute("jdbcUserRepository", UserRepository);
            sce.getServletContext().setAttribute("authenticationService", authenticationService);
            sce.getServletContext().setAttribute("registrationService", registrationService);
            sce.getServletContext().setAttribute("outputService", outputService);
            System.out.println(connection.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
