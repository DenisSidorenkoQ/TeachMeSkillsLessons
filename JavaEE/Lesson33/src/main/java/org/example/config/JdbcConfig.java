package org.example.config;

import org.example.service.user.PasswordEncrypter;
import org.example.session.AuthorizedUser;
import org.example.validator.UserValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.annotation.SessionScope;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class JdbcConfig {
    @Bean
    public Connection connection(
            @Value("${driverClassname}") final String driveClassName,
            @Value("${databaseUrl}") final String databaseUrl,
            @Value("${username}") final String username,
            @Value("${password}") final String password
    ) throws SQLException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driveClassName);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource.getConnection();
    }

    @Bean
    public PasswordEncrypter passwordEncrypter(@Value("${salt}") final String salt) {
        return new PasswordEncrypter(salt.getBytes());
    }

    @Bean
    @SessionScope
    public AuthorizedUser authorizedUser() {
        return new AuthorizedUser();
    }

    @Bean
    public UserValidator userValidation() {
        return new UserValidator();
    }
}
