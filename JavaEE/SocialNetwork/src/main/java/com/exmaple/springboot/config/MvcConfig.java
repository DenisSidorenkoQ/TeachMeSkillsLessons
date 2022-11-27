package com.exmaple.springboot.config;

import com.exmaple.springboot.interceptor.AuthInterceptor;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    private final AuthorizedUser authorizedUser;

    private static final List<String> ALLOWED_PATHS = List.of("/authorizationPage", "/authorization", "/registrationPage", "/users",
            "/Error");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MappedInterceptor(new String[]{"/*"},
                new AuthInterceptor(authorizedUser))).excludePathPatterns(ALLOWED_PATHS);
    }
}
