<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/20/2023
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${mess}</p>
<a href="/student/create">create</a>
<table>
    <thead>
    <tr>
        <th>stt</th>
        <th>id</th>
        <th>ten</th>
        <th>ten lop</th>
        <th>gioi tinh</th>
        <th>ngon ngu</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" varStatus="loop" var="student">
        <tr>
            <td><c:out value="${loop.count}"/></td>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.className}"/></td>
            <td><c:out value="${student.gender}"/></td>
            <td>
                <c:forEach items="${student.language}" varStatus="loop" var="item">
                    <c:out value="${item} "/>
                </c:forEach>
            </td>
            <td><a href="/student/detail?id=${student.id}">detail1</a></td>
            <td><a href="/student/detail/${student.id}">detail2</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
