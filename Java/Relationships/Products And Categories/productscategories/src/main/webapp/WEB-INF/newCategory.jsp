<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>New Category</title>
</head>
<body>
	<h2>New Category</h2>
	<a href="/">Home</a>
	<hr>
	<form:form action="/categories" method="post" modelAttribute="category" >
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:errors path="name"></form:errors></td>
				<td><form:input path= "name"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>