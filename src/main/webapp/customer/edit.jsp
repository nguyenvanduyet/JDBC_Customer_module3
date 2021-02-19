<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/02/2021
  Time: 10:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${c.getName()}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${c.getAddress()}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="edit"></td>
        </tr>
    </table>
</form>
</body>
</html>
