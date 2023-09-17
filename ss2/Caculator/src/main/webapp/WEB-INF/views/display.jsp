<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/17/2023
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Caculator</h1>
  <form action="cal" method="post">
      <div>
          <input type="text" name="number1" value="${number1}">
          <c:if test="${map.get('num1')!=null}">
              <c:out value="${map.get('num1')}"/>
          </c:if>
          <input type="text" name="number2" value="${number2}">
          <c:if test="${map.get('num2')!=null}">
              <c:out value="${map.get('num2')}"/>
          </c:if>
      </div>
      <br>
      <div>
          <button type="submit" name="button" value="add">add</button>
          <button type="submit" name="button" value="sub">sub</button>
          <button type="submit" name="button" value="mul">mul</button>
          <button type="submit" name="button" value="div">div</button>
      </div>
  </form>
  <p>kết quả : ${result}</p>
  </body>
</html>
