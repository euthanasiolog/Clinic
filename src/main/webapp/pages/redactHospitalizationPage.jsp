<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 07.12.17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${hospitalization.patient.secondName.toUpperCase()} ${hospitalization.patient.firstName.toUpperCase()} ${hospitalization.patient.patronymic.toUpperCase()}</h3>
<div>
    В больнице с <strong>${hospitalization.startHospitalization}</strong>
    <c:if test="${hospitalization.endHospitalization!=null}">
        по <strong><c:out value="${hospitalization.endHospitalization}"/></strong>
        выписан из отделении ${hospitalization.patient.lastDepartment}
    </c:if>
    <c:if test="${hospitalization.endHospitalization==null}">
        по настоящее врмемя в отделении ${hospitalization.patient.lastDepartment}
    </c:if>
    <br>

</div>

<div>
    <c:forEach var="deps" items="${hospitalization.departmentStamps}">
        В отделении <c:out value="${deps.departmentName}"/> c <c:out value="${deps.fromTime}"/> по
        <c:if test="${deps.toTime!=null}">${deps.toTime}</c:if>
        <c:if test="${deps.toTime==null}">настоящее время.<br>
        <form method="get" action="/endHospitalization">
            <select name="hospitalizationId" hidden>
                <option name="hospitalizationId">${hospitalization.id}</option>
            </select>
            <button type="submit" value="${hospitalization.patient.id}" name="patientId">Завершить госпитализацию</button>
        </form>
        </c:if>
        <br>
    </c:forEach>
</div>
<div>
<form action="/patientPage" method="get">
<button type="submit" value="${hospitalization.patient.id}" name="id">Назад</button>
</form>
</div>
</body>
</html>
