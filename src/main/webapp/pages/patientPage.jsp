<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 14.06.17
  Time: 19:41
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
    <h3>Страница пациента ${patient.secondName.toUpperCase()} ${patient.firstName.toUpperCase()} ${patient.patronymic.toUpperCase()}</h3>
    <div>
        <c:out value="${patient.dateOfBirth}"/><br>
        <c:out value="${patient.adress}"/><br>
        <c:forEach var="hospitalization" items="${patient.hospitalizations}">
            <c:out value="${hospitalization.startHospitalization}"/>
            <c:out value="${hospitalization.endHospitalization}"/>
            <c:out value="${hospitalization.isHospitalizationActual}"/>
        </c:forEach><br>
    </div>



</div>
<label for="nh">Добавить госпитализацию</label><br>
<form action="/newHospitalization" name="id" method="get" id="nh">
<input name="id" value="${patient.id}" hidden disabled>
    <input type="submit">
</form>
</body>
</html>