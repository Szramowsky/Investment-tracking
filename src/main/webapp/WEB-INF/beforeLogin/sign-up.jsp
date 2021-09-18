<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 08.09.2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>

<html>
<style>
    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box}

    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }
    .container {
        padding: 16px;
        display: flex;
        justify-content: center;
        align-content: center;
    }
    button {
        background-color: #04AA6D;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }
</style>
<div class="container">
    <table>
        <form:form method="post" modelAttribute="appUser">
            <tr>
                <td><form:label path="username">Username:</form:label></td>
                <td><form:input path="username" type="text"/></td>
                <td><form:errors path="username"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Password:</form:label></td>
                <td><form:input path="password" type="password"/></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Sign up</button></td>
            </tr>
        </form:form>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
