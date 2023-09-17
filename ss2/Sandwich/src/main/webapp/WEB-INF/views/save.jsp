<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/17/2023
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>danh sách gia vị</h1>
<c:forEach items="${condiment}" var="condiment" varStatus="loop">
    <p><c:out value="${condiment}"/></p>
</c:forEach>
</body>
</html>
