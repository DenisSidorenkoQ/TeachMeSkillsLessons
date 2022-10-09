<%@ page import="com.teachmeskills.repository.JdbcUserRepository" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.teachmeskills.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.Writer" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 09.10.2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Output</title>
</head>
<body>
<table>
<tr>
    <%
        Connection connection = (Connection) config.getServletContext().getAttribute("connection");
        JdbcUserRepository jdbcUserRepository = new JdbcUserRepository(connection);
        List<User> users = jdbcUserRepository.getAllUsers();

        String queryParameter = request.getParameter("parameter");
        if (queryParameter != null) {
            users = jdbcUserRepository.getAllUsers(queryParameter);
        } else {
            users = jdbcUserRepository.getAllUsers();
        }

        Writer writer = response.getWriter();
        users.stream().forEach(user -> {
            try {
                writer.write("<h1>" + user.getUsername() + "</h1>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    %>
</tr>
</table>
</body>
</html>
