<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>thêm mới</h1>
<form:form modelAttribute="student" action="/student/create" method="post">
    <form:input path="id"/><br>
    <form:input path="name"/><br>
    <form:radiobutton path="gender" value="1" label="Nam"/>
    <form:radiobutton path="gender" value="-1" label="Nữ"/>
    <form:radiobutton path="gender" value="0" label="LGBT"/><br>
    <form:select path="className" items="${className}"/>
    <form:checkboxes path="languages" items="${languages}"/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
