<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 09.06.17
  Time: 13:34
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
<div>
    <label for="nh">Добавить госпитализацию: </label><br>
    <form:form action="/newHospitalization" method="post" commandName="newHospitalization" id="nh">
        <label for="dep">Выберите отделение:</label>
        <form:select path="departmentName" id="dep">
            <c:forEach var="dep" items="${departments}">
                <form:option value="${dep.name}">${dep.name}</form:option>
            </c:forEach>
    </form:select><br>
        <div hidden >
        <form:select path="id">
            <form:option value="${id}">${id}</form:option>
        </form:select>
        </div>
        <button type="submit">Добавить</button>
    </form:form>
</div>
<a href="/mainDoctorPage">На главную</a>
</body>
</html>
