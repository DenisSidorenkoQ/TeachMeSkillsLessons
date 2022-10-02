package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/increment")
public class IncrementServlet extends HttpServlet {
    private final int DEFAULT_COUNTER_VALUE = 0;
    private AtomicInteger counter;

    @Override
    public void init() throws ServletException {
        counter = new AtomicInteger(DEFAULT_COUNTER_VALUE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()){
            writer.write("<h2>Method: " + req.getMethod() + "</h2><h2>Counter: " + counter + "</h2><h2>Servlet name: " +
                    req.getHttpServletMapping().getServletName() + "</h2>IP: " + req.getLocalAddr());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter.getAndIncrement();

    }

}
