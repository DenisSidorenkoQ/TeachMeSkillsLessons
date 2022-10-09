package com.teachmeskills.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.LogRecord;

@WebFilter(urlPatterns = "/Output.jsp",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 1) {
            for (Cookie c : cookies) {
                String name = c.getName();
                String password = c.getValue();
                System.out.println(name + "\n" + password);
            }
            filterChain.doFilter(request,response);
        } else {
            request.getRequestDispatcher("/Authorization.jsp").forward(request, response);
        }
    }
}
