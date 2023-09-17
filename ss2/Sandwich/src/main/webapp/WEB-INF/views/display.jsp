<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/17/2023
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .checkbox-container{
            display: inline-block;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<h1>sandwich condiments</h1>
<form action="save" method="post">
    <div class="checkbox-container">
        <input type="checkbox" id="checkbox1" name="condiment" value="letture">
        <label>letture</label>
    </div>

    <div class="checkbox-container">
        <input type="checkbox" id="checkbox2" name="condiment" value="tomato">
        <label>tomato</label>
    </div>

    <div class="checkbox-container">
        <input type="checkbox" id="checkbox3" name="condiment" value="mustard">
        <label>mustard</label>
    </div>

    <div class="checkbox-container">
        <input type="checkbox" id="checkbox4" name="condiment" value="sprouts">
        <label>sprouts</label>
    </div>
    <div>
        <button type="submit">save</button>
    </div>
</form>
</body>
</html>
