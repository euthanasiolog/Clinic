<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 07.12.17
  Time: 14:40
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
    </c:if>
</div>
<div>
 <form action="/endHospitalization" method="post">
     <select name="hospitalizationId" hidden>
         <option name="hospitalizationId">${hospitalization.id}</option>
     </select>
     <label for="time">Время выписки:</label><br>
     <input type="datetime-local" name="time" id="time"><br>
     <button type="submit">Завершить госпитализацию</button><br>
 </form>
</div>
<form action="/redactHospitalization" method="get">
    <button type="submit" value="${hospitalization.id}" name="hospitalizationId">Назад</button>
</form>
</body>
</html>
