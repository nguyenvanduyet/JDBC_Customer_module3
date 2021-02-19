<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/02/2021
  Time: 8:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<form action="/customer">
    <input type="search" name="action" hidden>
    <input type="text" name="name" placeholder="nhập tên">
    <input type="submit" value="Tìm Kiếm">
</form>
<table>
    <tr>
        <td>Name</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${c}" var="customer">
    <tr>
        <td>${customer.getName()}</td>
        <td>${customer.getAddress()}</td>
        <td><a href="/customer?action=edit&id=${customer.getId()}" >Edit</a></td>
        <td><a href="/customer?action=delete&id=${customer.getId()}" >Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
