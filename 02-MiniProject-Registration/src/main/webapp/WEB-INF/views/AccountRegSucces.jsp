<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/myapp.js"></script>
<script src="../js/app.js"></script>

<script>
	
</script>



</head>
<body>
<h1>Registration Forms</h1>

<form:form action="userRegSave" method="post" modelAttribute="user">
<table>

<tr>
<th>First Name</th>
<td><form:input path="firstName"/></td>
</tr>

<tr>
<th>Last Name</th>
<td><form:input path="lastName"/></td>
</tr>

<%-- <tr>
<th>Email</th>
<td><form:input path="email"/></td>
</tr> --%>

<tr>
<td>Contact Email:</td>
				<td><form:input path="userEmail" />
					<font color='red'>
						<div id="dupEmail"></div>
					</font>		
				</td>
			</tr>

<tr>
<th>Phone Number</th>
<td><form:input path="phonNumber"/></td>
</tr>

<tr>
<th>Date of Birth</th>
<td><form:input path="DateOfBirth" /></td>
</tr>

<tr>
<th>Gender</th>
<td>Male:<form:radiobutton path="Gender" value="M" id="gender"/>
Female:<form:radiobutton path="Gender" value="F" id="gender"/>
</td>
</tr>
   
   <tr>
   <th>Country:</th>
   <td><form:select path="countryId">
   <form:option value="">-Select-</form:option>  
   <form:options items="${countryMap}"/>
   </form:select>
   </td>
   </tr>
   
   <tr>
   <th>State:</th>
   <td>
   <form:select path="stateId">
   <form:option value="">-Select-</form:option>
   </form:select>
   </td>
   </tr>
  
   
  <tr>
				<th>City:</th>
				<td><form:select path="cityId">
						<form:option value="">-Select-</form:option>
					</form:select></td>
					
			</tr>

 <tr>
     <td><input type="submit" value="Save"/>
     <input type="reset" value="Reset"/></td>
     </tr>  
</table>

</form:form>

${succMsg}
${errMsg}
</body>
</html>