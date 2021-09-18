<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 10.09.2021
  Time: 09:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="loggedHeader.jsp"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
        }

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .content {
            background-color: #ddd;
            padding: 10px;
            text-align: center;
            display: flex;
            justify-content: center;
            align-content: center;

        }

        #crypto {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #crypto td, #crypto th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        #crypto th {
            padding-top: 12px;
            padding-bottom: 12px;
            color: black;
        }

    </style>
</head>
<table>
    <tr>
        <td>TOTAL VALUE</td>
        <td>$ <c:out value="${(total * 100)/100}"/></td>
    </tr>
</table>
<div class="content">
    <table id="crypto">
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
                <td>$ ${c.total}</td>

            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>