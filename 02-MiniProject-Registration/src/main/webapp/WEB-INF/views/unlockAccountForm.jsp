<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rectifation Forms</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/myapp1.js"></script>

</head>
<body>
    <font color='red'>${errMsg}</font>
    <form:form action="unlockUserAcc" modelAttribute="unlockAcc" method="POST">    
    <font color='red'><span id="errId"></span></font>
    
    <table>
    <%-- <tr>
    <td>Your Email:</td>
    <td>${email}</td>
    </tr> --%>
    
    <tr>
    <td>Your Email:</td>
    <td><form:input path="email" readonly="true"/> </td>
    </tr>
    
    
    
    <tr>
    <td>Enter Temporary Password</td>
    <td><form:password path= "tempPwd"/>  </td>
    </tr>
    
    <tr>
    <td>Enter New Password</td>
    <td><form:password path="newPwd"/>  </td>
    </tr>
    
    <tr>
    <td>Enter New Password</td>
    <td><form:password path="confirmPwd"/>  </td>
    </tr>
    <tr>
    <td><input type="submit" value="Unlock" onclick="return validatePwds()"></td>
    </tr>
    </table>
    </form:form>
</body>
</html>