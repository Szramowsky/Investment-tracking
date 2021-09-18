<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szramowsky
  Date: 16.09.2021
  Time: 09:54
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
        }
        #crypto th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            color: black;
        }

    </style>
</head>
<div class="content">
<table id="crypto">
    <tr>
        <td>Name</td>
        <td>Symbol</td>
        <td>Price</td>
        <td>24h %</td>
        <td>7d %</td>
    </tr>
    <c:forEach items="${cryptoList}" var="crypto">
        <tr>
            <td>${crypto.name}</td>
            <td>${crypto.currencySymbol}</td>
            <td>$ ${Math.floor(crypto.valuesInDollar *100)/100}</td>
            <td>${Math.floor(crypto.percent_change_24h *100)/100}</td>
            <td>${Math.floor(crypto.percent_change_7d *100)/100}</td>
        </tr>
        <tr></tr>
    </c:forEach>
</table>
</div>