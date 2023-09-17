<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/17/2023
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>hello,bye,say,love</p>
<form action="dich" method="post">
    <input type="text" name="anh" placeholder="nhập từ tiếng anh">
    <button type="submit">dịch</button>
</form>
<p>bản dịch : <c:out value="${viet}"/></p>
</body>
</html>
