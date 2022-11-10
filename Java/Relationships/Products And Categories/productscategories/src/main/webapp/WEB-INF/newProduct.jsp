<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>New Product</title>
</head>
<body>
	<h2>New Product</h2>
	<a href="/">Home</a>
	<hr>
	<form:form action="/products" method="post" modelAttribute="product" >
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:errors path="name"></form:errors></td>
				<td><form:input path= "name"/></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:errors path="description"></form:errors></td>
				<td><form:input path= "description"/></td>
			</tr>
			<tr>
				<td><form:label path="price">Price:</form:label></td>
				<td><form:errors path="price"></form:errors></td>
				<td><form:input path= "price"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>