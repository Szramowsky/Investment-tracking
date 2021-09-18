<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 10.09.2021
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="loggedHeader.jsp"/>

<table>
    <tr>
        <th>Name</Th>
        <th>Symbol</th>
        <th>Quantity</th>
        <th>Actual value</th>
        <th></th>
    </tr>
    <c:forEach items="${wallet}" var="c">
        <tr>
            <td>${c.name}</td>
            <td>${c.ticker}</td>
            <td>${c.quantity}</td>
            <td>$${c.total}</td>

        </tr>
    </c:forEach>

</table>

</body>
</html>
