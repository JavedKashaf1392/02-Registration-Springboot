<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to forgot Page</h2>

<form:form action="/userForgotPage" modelAttribute="forgot" method="POST">
<table>
<tr>
<th>Email</th>
<td><form:input path="email"/><td>
</tr>

<tr>
<td><input type="submit">Get OTP &nbsp;
<input type="reset">Reset
</td>
</tr>

</table>

</form:form>

</body>
</html>