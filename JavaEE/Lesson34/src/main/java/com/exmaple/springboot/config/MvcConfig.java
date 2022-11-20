package com.exmaple.springboot.config;

import com.exmaple.springboot.interceptor.AuthInterceptor;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    private final AuthorizedUser authorizedUser;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MappedInterceptor(new String[]{
            "/Chat", "/Friends",
            "/Friends", "/IncomingRequests",
            "/OutgoingRequests", "/Users",
            "/Authorization", "/Registration"
        }, new AuthInterceptor(authorizedUser)));
    }
}
