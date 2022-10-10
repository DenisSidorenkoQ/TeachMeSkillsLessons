<%@ page import="com.teachmeskills.repository.JdbcUserRepository" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.teachmeskills.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.Writer" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.teachmeskills.service.AuthenticationService" %>
<%@ page import="com.teachmeskills.service.OutputService" %><%--
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
        OutputService outputService =
                (OutputService) request.getServletContext().getAttribute("outputService");
        String queryParameter = request.getParameter("parameter");
        List<User> users = outputService.getAllUsers(queryParameter);

        try (Writer writer = response.getWriter()) {
            outputService.outputList(users, writer);
        }
    %>
</tr>
</table>
</body>
</html>
