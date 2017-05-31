<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 28.05.17
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hi!</title>
</head>
<body>
    <form:form action="/signIn" method="post" commandName="signIn">
        <div>Введите логин:</div>
        <form:input path="name"/><br>
        <div>Введите пароль:</div>
        <form:password path="password"/><br>
        <input type="submit">
    </form:form>
</body>
</html>
