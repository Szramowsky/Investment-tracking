<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 09.09.2021
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="loggedHeader.jsp"/>
<table>

        <tr>Add crypto in your wallet</tr>
        <tr>
            <form:form method="post" modelAttribute="wallet">
            <td>Currency Ticker</td>
            <td><form:select path="currency_ticker" items="${cryptoList}" itemLabel="name" itemValue="currencySymbol"/></td>
            <td><form:errors path="currency_ticker"/></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><form:input path="quantity"/></td>
            <td><form:errors path="quantity"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Do it!"></td>
        </tr>

    </form:form>
</table>
</body>
</html>
