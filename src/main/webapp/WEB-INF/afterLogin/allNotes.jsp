<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 18.09.2021
  Time: 06:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="loggedHeader.jsp"/>

<h2>All your notes</h2>

<table>
    <c:forEach items="${notesList}" var="note">
        <tr>
            <td>Date - ${note.time}</td>
        </tr>
        <tr>
            <td>Note - ${note.text}</td>
        </tr>
        <tr>
            <td><a href="/delete/<c:out value="${note.id}"/>">Delete</a> </td>
        </tr>
        <tr>
            <td>-----</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
