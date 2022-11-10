<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Product Page</title>
</head>
<body>
	<h3>${product.name}</h3>
	<a href="/">Home</a>
	<hr>
	<h3>Categories</h3>
	<c:forEach var="categ" items="${product.categories}">
		<ul>
			<li><c:out value="${categ.name}"></c:out></li>
		</ul>
	</c:forEach>
	<hr>
	<h3>Add Category:</h3>
	<form action="/addCategory/${product.id}" method="post">
	<select name="categoryId">
		<c:forEach var="categ" items="${categories}">
			<option value="${categ.id}"><c:out value="${categ.name}"></c:out></option>
		</c:forEach>
	</select>
	<input type="submit" value="Add">
	</form>
</body>
</html>