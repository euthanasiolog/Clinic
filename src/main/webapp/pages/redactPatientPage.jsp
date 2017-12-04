<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 27.11.17
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><strong>${patient.firstName.toUpperCase()} ${patient.secondName.toUpperCase()} ${patient.patronymic.toUpperCase()}</strong></h1>
<form action="/redactPatient" method="post">
    <select name="id" hidden>
        <option name="id">${patient.id}</option>
    </select>
<label for="firstName">Имя</label><br>
<input placeholder="${patient.firstName}" type="text" name="firstName" id="firstName"><br>
<label for="secondName">Фамилия</label><br>
<input placeholder="${patient.secondName}" type="text" name="secondName" id="secondName"><br>
<label for="patronymic">Отчество</label><br>
<input placeholder="${patient.patronymic}" type="text" name="patronymic" id="patronymic"><br>
<label for="adress">Адрес:</label><br>
<input placeholder="${patient.adress}" type="text" name="adress" id="adress"><br>
<label for="sex">Пол:</label><br>
<input type="radio" name="sex" id="sex" value="MALE">M<input type="radio" name="sex" value="FEMALE">Ж<br>
<label for="dateOfBirth">Дата рождения:</label><br>
<input type="date" name="dateOfBirth" id="dateOfBirth"><br>

<br><br><button type="submit">Редактировать</button>
</form>
<a href="/mainDoctorPage">На главную</a>
</body>
</html>
