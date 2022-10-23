<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <c:choose>
      <c:when test="${param.page == 1}">
        <li class="breadcrumb-item active" aria-current="page">UsersList</li>
        <li class="breadcrumb-item"><a href="friends">Friends</a></li>
        <li class="breadcrumb-item"><a href="incomingRequests">Incoming requests</a></li>
        <li class="breadcrumb-item"><a href="outgoingRequest">Outgoing requests</a></li>
      </c:when>
      <c:when test="${param.page == 2}">
        <li class="breadcrumb-item"><a href="Users.jsp">UsersList</a></li>
        <li class="breadcrumb-item active" aria-current="page">Friends</li>
        <li class="breadcrumb-item"><a href="incomingRequests">Incoming requests</a></li>
        <li class="breadcrumb-item"><a href="outgoingRequest">Outgoing requests</a></li>
      </c:when>
      <c:when test="${param.page == 3}">
        <li class="breadcrumb-item"><a href="Users.jsp">UsersList</a></li>
        <li class="breadcrumb-item"><a href="friends">Friends</a></li>
        <li class="breadcrumb-item active" aria-current="page">Incoming requests</li>
        <li class="breadcrumb-item"><a href="outgoingRequest">Outgoing requests</a></li>
      </c:when>
      <c:when test="${param.page == 4}">
        <li class="breadcrumb-item"><a href="Users.jsp">UsersList</a></li>
        <li class="breadcrumb-item"><a href="friends">Friends</a></li>
        <li class="breadcrumb-item"><a href="incomingRequests">Incoming requests</a></li>
        <li class="breadcrumb-item" aria-current="page">Outgoing requests</li>
      </c:when>
      <c:otherwise>
        do this when nothing else is true
      </c:otherwise>
    </c:choose>
  </ol>
</nav>

