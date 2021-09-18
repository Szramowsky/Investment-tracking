<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 17.09.2021
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<h1>Hello <c:out value="${username}"/></h1>
<h3>Registration was successful, to start using the site please log in first</h3>
<h3><a href="<c:url value="/login"/>">Start</a> </h3>

</body>
</html>
