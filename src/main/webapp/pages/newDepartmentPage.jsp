<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 14.06.17
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <label for="newDepartment">Создать отделение: </label><br>
    <form:form id="newDepartment" action="/newDepartment" method="post" commandName="newDepartment">
        <label for="name">Название отделения: </label><br>
        <form:input path="name" id="name"/><br><br>
        <label for="volume">Вместимость отделения: </label><br>
        <form:input path="volume" id="volume"/><br><br>
        <label for="sex">Пол отделения: </label><br>
        <form:select path="sex" id="sex">
            <form:option value="N/A"/>
            <form:option value="М"/>
            <form:option value="Ж"/>
        </form:select><br><br>
        <button type="submit">Добавить</button><br>
    </form:form>
</div>
<a href="/mainDoctorPage">На главную</a>
</body>
</html>
