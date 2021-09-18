<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 17.09.2021
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="loggedHeader.jsp"/>

<h1>Congratulations!!</h1>
<h3><c:out value="${line}"/></h3>
<h3>Now you have <c:out value="${line2}"/></h3>

</body>
</html>
