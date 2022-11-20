package com.exmaple.springboot.config;

import com.exmaple.springboot.session.AuthorizedUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SessionConfig {
    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    @SessionScope
    public AuthorizedUser authorizedUser() {
        return new AuthorizedUser();
    }
}