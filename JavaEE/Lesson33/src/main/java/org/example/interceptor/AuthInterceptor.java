package org.example.interceptor;

import lombok.RequiredArgsConstructor;
import org.example.session.AuthorizedUser;
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
        if (authorizedUser.getUserId() != null && authorizedUser.getUsername() != null) {
            return true;
        }
        response.sendRedirect("AuthorizationPage");
        return false;
    }


}
