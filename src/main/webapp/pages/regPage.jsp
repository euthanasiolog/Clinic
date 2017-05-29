<%--
  Created by IntelliJ IDEA.
  User: piatr
  Date: 28.05.17
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"   uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hi!</title>
</head>
<body>
<form:form action="/reg" method="post" commandName="regForm">
    <form:input path="name"/><br>
    <form:input path="email" /><br>
    <form:password path="password" /><br>
    <form:password path="confirmPassword"/><br>
    <input type="submit">
</form:form>
</body>
</html>
