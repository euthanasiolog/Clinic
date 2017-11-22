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
    <form:select path="departmentName">
            <c:forEach var="dep" items="${departments}">
                <form:option value="${dep.name}">${dep.name}</form:option>
            </c:forEach>
    </form:select><br>
        <div >
        <form:select path="id">
            <form:option value="${id}">${id}</form:option>
        </form:select>
        </div>
        <input type="submit">
    </form:form>
</div>
</body>
</html>
