<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>New Ninja</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<main>
	<h2>New Ninja</h2>
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<table>
			<tr>
				
				<td><form:label path="dojo">Dojo:</form:label></td>
				<td><form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
						<option value="${dojo.id}">${dojo.name}</option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:errors path="firstName"></form:errors></td>
				<td><form:input path= "firstName"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:errors path="lastName"></form:errors></td>
				<td><form:input path= "lastName"/></td>
			</tr>
			<tr>
				<td><form:label path="age">Age:</form:label></td>
				<td><form:errors path="age"></form:errors></td>
				<td><form:input path= "age"/></td>
			</tr>
		</table>
		<input type="submit" value="Create">
	</form:form>
	</main>
</body>
</html>