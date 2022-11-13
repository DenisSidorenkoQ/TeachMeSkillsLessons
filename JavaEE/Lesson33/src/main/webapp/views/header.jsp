<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
      <c:set var="firstPageParam" value="<a href=\"output\">UsersList</a>"/>
      <c:set var="secondPageParam" value="<a href=\"friendList\">Friends</a>"/>
      <c:set var="thirdPageParam" value="<a href=\"incomingRequests\">Incoming requests</a>"/>
      <c:set var="fourthPageParam" value="<a href=\"outgoingRequest\">Outgoing requests</a>"/>
    <c:choose>
      <c:when test="${param.page == 1}">
          <c:set var="firstPageParam" value="UsersList"/>
      </c:when>
      <c:when test="${param.page == 2}">
          <c:set var="secondPageParam" value="Friends"/>
      </c:when>
      <c:when test="${param.page == 3}">
          <c:set var="thirdPageParam" value="Incoming requests"/>
      </c:when>
      <c:when test="${param.page == 4}">
          <c:set var="fourthPageParam" value="Outgoing requests"/>
      </c:when>
    </c:choose>

    <li class="breadcrumb-item active">${firstPageParam}</li>
    <li class="breadcrumb-item active">${secondPageParam}</li>
    <li class="breadcrumb-item active">${thirdPageParam}</li>
    <li class="breadcrumb-item active">${fourthPageParam}</li>
  </ol>
</nav>

