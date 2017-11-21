<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 21.11.17
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>
    <form method="get" action="/departments">
        <c:forEach var="deps" items="${departments}">
            <c:out value="${deps.name}"/> | <c:out value="${deps.sex}"/> | <c:out value="${deps.volumeOfDepartment}"/><br>
        </c:forEach>
    </form>
</body>
</html>
