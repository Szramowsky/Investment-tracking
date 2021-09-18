<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 18.09.2021
  Time: 06:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="loggedHeader.jsp"/>

<table>
    <tr>Add note</tr>
    <form:form method="post" modelAttribute="notes">
        <tr>
            <td><form:input path="text"/></td>
            <td><form:errors path="text"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add notes"></td>
        </tr>
    </form:form>
</table>

</body>
</html>
