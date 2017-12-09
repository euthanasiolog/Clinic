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
        Дата рождения: <c:out value="${patient.dateOfBirth}"/><br>
        Адрес: <c:out value="${patient.adress}"/><br>
        Список госпитализаций:<br> <c:forEach var="hospitalization" items="${patient.hospitalizations}">
            <c:if test="${hospitalization.isHospitalizationActual}">
                Актуальная госпитализация:
            </c:if>
            <c:out value="${hospitalization.startHospitalization}"/>
            <c:out value="${hospitalization.endHospitalization}"/>
            <form action="/redactHospitalization" method="get">
                <button type="submit" name="hospitalizationId" value="${hospitalization.id}">Перейти к госпитализации</button>
            </form>
            <c:if test="${hospitalization.isHospitalizationActual}">
            <form action="/endHospitalization" method="get">
                <button type="submit" value="${hospitalization.id}" name="hospitalizationId">Завершить госпитализацию</button>
            </form>
            </c:if>
        <br></c:forEach><br>
    </div>


</div>
<label for="nh">Добавить госпитализацию</label><br>
<form action="/newHospitalization" name="id" method="get" id="nh">
<select name="id" hidden>
    <option name="id">${patient.id}</option>
</select>
    <button type="submit">Добавить</button>
</form>
<form action="/redactPatient">
    <select name="id" hidden>
        <option name="id">${patient.id}</option>
    </select>
    <button type="submit">Редактировать</button>
</form>
</form>
<a href="/createPatient">Ещё пациента?</a><br><br>
<a href="/mainDoctorPage">На главную</a>
</body>
</html>
