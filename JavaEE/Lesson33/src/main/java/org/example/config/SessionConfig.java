package org.example.config;

import org.example.session.AuthorizedUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SessionConfig {
    @Bean
    @SessionScope
    public AuthorizedUser authorizedUser() {
        return new AuthorizedUser();
    }
}
