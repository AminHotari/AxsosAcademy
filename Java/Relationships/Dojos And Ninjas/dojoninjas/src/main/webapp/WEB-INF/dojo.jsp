<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>New Dojo</title>
</head>
<body>
	<h2>New Dojo</h2>
	<form:form action="/dojos" method="post" modelAttribute="dojo">
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:errors path="name"></form:errors></td>
				<td><form:input path= "name"/></td>
			</tr>
		</table>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>