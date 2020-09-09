<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${errMsg}</h2>
	<h2>${msg}</h2>
	<h2>Login here</h2>

	<form:form action="userHomePage" method="POST"
		modelAttribute="userSignIn">
		<table align="center">


			<tr>
				<th>Email
				<th>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<th>Passowrd
				<th>
				<td><form:input path="pazzword" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="SignIn" /> <input type="reset"
					value="Reset" /></td>
			</tr>

			<tr>
				<td><a href="/loadForm">SignUp</a> &nbsp; <a href="forgotPageForm">Forgot
						Password</a>
				<td>
			</tr>

		</table>

	</form:form>


</body>
</html>