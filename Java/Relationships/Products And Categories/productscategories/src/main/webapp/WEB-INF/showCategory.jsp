<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Category Page</title>
</head>
<body>
	<h3>${category.name}</h3>
	<a href="/">Home</a>
	<hr>
	<h3>Products</h3>
	<c:forEach var="prod" items="${category.products}">
		<ul>
			<li><c:out value="${prod.name}"></c:out></li>
		</ul>
	</c:forEach>
	<hr>
	<h3>Add Product:</h3>
	<form action="/addProduct/${category.id}" method="post">
	<select name="productId">
		<c:forEach var="prod" items="${products}">
			<option value="${prod.id}"><c:out value="${prod.name}"></c:out></option>
		</c:forEach>
	</select>
	<input type="submit" value="Add">
	</form>
</body>
</html>