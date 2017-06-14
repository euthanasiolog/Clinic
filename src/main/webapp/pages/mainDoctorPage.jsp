<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 01.06.17
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    Выберите отделение:
    <form action="/setDepartmentDoctor" method="post">
        <select>
            <c:forEach var="dep" items="${departments}">
                <c:out value="${dep}"/><br>
            </c:forEach>
        </select>
    </form>
</div>

    <div align="right">
        <a href="">добавить пациента</a>
    </div>
<div>
    <table border="3">
        <tr>
            <th>№</th>
            <th>ФИО</th>
            <th>Дата рождения</th>
            <th>Диагноз</th>
            <th>Дата поступления</th>
            <th>Что-то еще</th>
            <th></th>
        </tr>
    <c:forEach var="patient" items="${patients}" varStatus="patientCount">
        <tr>
            <td>${patientCount+1}</td>
            <td>${patient.name}</td>
            <%--<td>${patientList}</td> тут продумать какие поля как выводить в таблицу--%>
        </tr>

    </c:forEach>
    </table>
</div>

</body>
</html>
