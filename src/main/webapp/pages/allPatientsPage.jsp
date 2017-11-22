<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 22.11.17
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="patient" items="${allPatients}" varStatus="numberPatient">
        <c:out value="${patient.secondName}"/>|
        <c:out value="${patient.firstName}"/>|
        <c:out value="${patient.patronymic}"/>|<form action="/patientPage" method="get">
        <button type="submit" name="id" value="${patient.id}">перейти</button>
        </form><br>
    </c:forEach>
</body>
</html>
