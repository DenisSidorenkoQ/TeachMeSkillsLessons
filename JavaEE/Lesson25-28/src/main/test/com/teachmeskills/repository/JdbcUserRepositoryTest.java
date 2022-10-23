package com.teachmeskills.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JdbcUserRepositoryTest {

    final GenericContainer container = new PostgreSQLContainer("postgres:13.4-alpine")
            .withUsername("postgres")
            .withPassword("postgres")
            .withDatabaseName("postgres")
            .withInitScript("resources/init.sql")
            .withExposedPorts(5432);

    private Connection connection;
    private JdbcUserRepository repository;

    @BeforeAll
    public void init() throws ClassNotFoundException, SQLException {
        container.start();
        final String dbDriver = "org.postgresql.Driver";
        final String username = "postgres";
        final String password = "postgres";
        final String dbUrl = "jdbc:postgresql://localhost:" + container.getMappedPort(5432) + "/postgres";

        Class.forName(dbDriver);
        connection = DriverManager.getConnection(dbUrl, username, password);
        repository = new JdbcUserRepository(connection);
    }

    @Test
    void shouldInsertNewUser() {
        final String testUsername = "test_username";
        final String testPassword = "test_password";

        if (repository.insertNewUser(testUsername, testPassword)) {
           Assertions.assertTrue(repository.isExists(testUsername, testPassword));
        }
    }
}
