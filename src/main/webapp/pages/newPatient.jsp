<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 03.06.17
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form>
        <label for="name">Имя: </label><br>
        <form:input id="name" path="name"/><br><br>
        <label for="secondName">Фамилия: </label><br>
        <form:input id="secondName" path="secondName"/><br><br>
        <label for="patronymic">Отчество: </label><br>
        <form:input id="patronymic" path="patronymic"/><br><br>
        <label for="adress">Адресс: </label><br>
        <form:input id="adress" path="adress"/><br><br>
        <input type="submit">
    </form:form>

</body>
</html>
