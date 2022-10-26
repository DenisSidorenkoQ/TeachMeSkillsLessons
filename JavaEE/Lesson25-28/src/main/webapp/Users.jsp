<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 09.10.2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c-rt" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<div class="card" style="width: 30rem;">
    <jsp:include page="header.jsp">
        <jsp:param name="page" value="1"/>
    </jsp:include>
    <div class="card-header text-success">
        Users
    </div>
    <ul class="list-group list-group-flush">
        <c:if test="${users == null}">
            <jsp:forward page="/output"/>
        </c:if>
        <c:if test="${users != null}">
            <c:forEach items="${users}" var="user" varStatus="loop">
                <c:if test="${user.getLogin() == username}">
                    <li class="list-group-item"><c:out value="${user.getLogin()}" /></li>
                </c:if>
                <c:if test="${user.getLogin() != username}">
                    <li class="list-group-item">
                        <c:out value="${user.getLogin()}" />
                        <form action='friendRequest?requestFriendId=${user.getUserId()}&requestFriendName=${user.getLogin()}' method='post'>
                            <button type="submit" class="mx-auto btn btn-outline-success btn-sm">
                                Add to friends
                            </button>
                        </form>
                    </li>
                </c:if>
            </c:forEach>
            <c:set var="user" value="null"/>
        </c:if>
    </ul>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
