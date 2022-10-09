package com.teachmeskills.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebListener
public class DependencyInitializationContextListener implements ServletContextListener {
    final String DB_DRIVER = "org.postgresql.Driver";
    final String USERNAME = "postgres";
    final String PASSWORD = "postgres";
    final String DB_URL = "jdbc:postgresql://postgres:5432/postgres";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Class.forName(DB_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            sce.getServletContext().setAttribute("connection", connection);
            System.out.println(connection.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
