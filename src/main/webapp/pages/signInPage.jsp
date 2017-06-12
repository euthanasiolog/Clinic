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
<div align="center">
    <form:form action="/signIn" method="post" commandName="signIn">
        <label for="user">Вы кто?</label>
        <form:select path="type" id="user">
            <form:option value="DoctorEntity">Доктор</form:option>
            <form:option value="NurseEntity">Медсестра</form:option>
        </form:select>
        <div>Введите логин:</div>
        <form:input path="login"/><br>
        <div>Введите пароль:</div>
        <form:password path="password"/><br>
        <hr>
        <input type="submit">
    </form:form>
</div>
</body>
</html>
