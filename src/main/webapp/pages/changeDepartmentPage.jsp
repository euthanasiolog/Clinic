<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 07.12.17
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/endHospitalization" method="post">
            <label for="dep">В какое отделение переводится:</label>
            <select id="dep" name="department">
                <c:forEach var="dep" items="${departments}">
                    <option name="department" value="${dep.name}">${dep.name}</option>
                </c:forEach>
            </select><br>
            <label for="time">Время перевода:</label>
            <input type="datetime" required name="date" id="time"><br>
            <button type="submit" value="${hospitalization.id}" name="hospitalizationId">Завершить</button>
        </form>
    </div>
</body>
</html>
