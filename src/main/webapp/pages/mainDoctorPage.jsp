<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 01.06.17
  Time: 21:05
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
    <a href="/newDepartment">Добавить отделение</a>
</div>
<div>

    <label for="deps"> Выберите отделение:</label><br>
    <form action="/setDepartmentDoctor" method="post" id="deps">
        <label for="dep"></label>
            <select id="dep" name="department">
            <c:forEach var="dep" items="${departments}">
                <option name="department" value="${dep.name}">${dep.name}</option>
            </c:forEach>
            </select><br>
        <input type="submit"><br>
    </form>
</div>
    <div align="right">
        <a href="/createPatient">добавить пациента</a>
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
        </tr>
    <c:forEach var="patient" items="${patients}" varStatus="patientCount">
        <tr>
            <td><c:out value="${patientCount+1}"/></td>
            <td><c:out value="${patient.firstName} ${patient.secondName} ${patient.patronymic}"/></td>
            <td><c:out value="${patient.dateOfBirth}"/></td>
            <td></td>
            <%--<td>${patientList}</td> тут продумать какие поля как выводить в таблицу--%>
        </tr>
    </c:forEach>
    </table>
</div>
<div>
    <a href="/departments">Список отделений</a>
</div>
</body>
</html>
