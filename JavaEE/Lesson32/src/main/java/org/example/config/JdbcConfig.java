package org.example.config;

import org.example.model.User;
import org.example.repository.JdbcUserRepository;
import org.example.repository.UserRepository;
import org.example.service.user.PasswordEncrypter;
import org.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

//    @Bean
//    public PasswordEncrypter passwordEncrypter(@Value("${salt}") final String salt) {
//        return new PasswordEncrypter(salt.getBytes());
//    }
//
//    @Bean
//    public UserRepository userRepository(
//            @Value("${driverClassname}") final String driveClassName,
//            @Value("${databaseUrl}") final String databaseUrl,
//            @Value("${username}") final String username,
//            @Value("${password}") final String password
//    ) throws SQLException {
//        return new JdbcUserRepository(connection(driveClassName, databaseUrl, username, password));
//    }
//
//    @Bean
//    public UserService userService(@Value("${driverClassname}") final String driveClassName,
//                                   @Value("${databaseUrl}") final String databaseUrl,
//                                   @Value("${username}") final String username,
//                                   @Value("${password}") final String password,
//                                   @Value("${salt}") final String salt
//    ) throws SQLException {
//        return new UserService(
//                userRepository(driveClassName, databaseUrl, username, password),
//                new PasswordEncrypter(salt.getBytes())
//        );
//    }
}
