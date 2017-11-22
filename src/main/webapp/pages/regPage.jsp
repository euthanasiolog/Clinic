<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 28.05.17
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hi!</title>
</head>
<body>
<div align="center">
<form:form action="/reg" method="post" commandName="regForm">
    <label for="login">Введите логин:</label><br>
    <form:input id="login" path="login"/><br><br>
    <label for="firstName">Введите имя:</label><br>
    <form:input id="firstName" path="firstName"/><br><br>
    <label for="secondName">Введите фамилию:</label><br>
    <form:input id="secondName" path="secondName"/><br><br>
    <label for="email">Введите адрес электронной почты:</label><br>
    <form:input id="email" path="email" /><br><br>
    <label for="password">Введите пароль:</label><br>
    <form:password id="password" path="password" /><br><br>
    <label for="comfirmPassword">Подтвердите пароль:</label><br>
    <form:password id="comfirmPassword" path="confirmPassword"/><br><br>
    <button type="submit">Зарегестрироваться</button>
</form:form>
</div>
</body>
</html>
