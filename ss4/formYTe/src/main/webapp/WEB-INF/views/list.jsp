<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/1/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ten</th>
        <th>CMND</th>
        <th>sua</th>
    </tr>
    <c:forEach var="person" items="${Plist}" varStatus="loop">
        <tr>
            <td>${person.ten}</td>
            <td>${person.CMND}</td>
            <td>
                <a href="/update/${person.CMND}">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
