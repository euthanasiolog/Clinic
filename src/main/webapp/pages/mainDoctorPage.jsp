<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 01.06.17
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="right">
        <a href="">добавить пациента</a>
    </div>
<div>
    <table>
        <tr>
            <th>№</th>
            <%--<th></th> тут столбцы, которые будут полями пациента--%>
        </tr>
    <c:forEach var="patient" items="${patientList}" varStatus="patientCount">
        <tr>
            <td>${patientCount}</td>
            <%--<td>${patientList}</td> тут продумать какие поля как выводить в таблицу--%>
        </tr>

    </c:forEach>
    </table>
</div>

</body>
</html>
