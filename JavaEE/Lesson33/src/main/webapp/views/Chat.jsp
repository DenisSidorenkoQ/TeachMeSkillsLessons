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

    <link href = "https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel = "stylesheet">
</head>
<body>

<c:forEach items="${messageList}" var="message" varStatus="loop">
    <c:if test="${message.senderId == userId}">
        <div aria-live="polite" aria-atomic="true" class="d-flex justify-content-left align-items-left p-4">
            <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <strong class="me-auto"><c:out value="${username}" /></strong>
                </div>
                <div class="toast-body">
                    <c:out value="${message.text}" />
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${message.recipientId == userId}">
        <div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center p-4">
                <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="toast-header">
                        <strong class="me-auto"><c:out value="${friendName}" /></strong>
                    </div>
                    <div class="toast-body">
                        <c:out value="${message.text}" />
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>
<form action='messages' method="post">
    <div class="p-4">
        <label for="message" class="form-label">Text</label>
        <input type="hidden" name="friendId" value="${friendId}"/>
        <input type="hidden" name="friendName" value="${friendName}"/>
        <textarea class="form-control" id="message" name="message" rows="3"></textarea>
        <button type='submit' class="mx-auto btn btn-outline-primary btn-sm">
            Send message
        </button>
    </div>
</form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
