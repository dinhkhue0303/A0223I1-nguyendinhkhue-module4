<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/15/2023
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/convert" method="post">
  <input type="text" name="vnd">
  <button type="submit">convert</button>
</form>
<p>Ket qua : ${usd}</p>
</body>
</html>
