<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/02/2021
  Time: 9:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Create</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id" placeholder="Enter Id"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" placeholder="Enter Name"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" placeholder="Enter Address"></td>
        </tr>
        <tr>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form>
</body>
</html>
