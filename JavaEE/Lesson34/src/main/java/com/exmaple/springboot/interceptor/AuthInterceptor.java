package com.exmaple.springboot.interceptor;

import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    private final AuthorizedUser authorizedUser;

    @Override
    @SuppressWarnings("PMD")
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler
    ) throws Exception {
        if (authorizedUser.getUserId() != null && authorizedUser.getLogin() != null) {
            return true;
        }
        response.sendRedirect("authorizationPage");
        return false;
    }


}
