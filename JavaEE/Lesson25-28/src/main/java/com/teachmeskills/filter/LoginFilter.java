package com.teachmeskills.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/Users.jsp", "/Friends.jsp", "/IncomingRequests.jsp", "/OutgoingRequests.jsp", "/outputFriends", "/incomingRequestsServlet", "/outgoingRequestServlet"},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if ((String) request.getSession().getAttribute("username") != null) {
            filterChain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/Authorization.jsp").forward(request, response);
        }
    }
}
