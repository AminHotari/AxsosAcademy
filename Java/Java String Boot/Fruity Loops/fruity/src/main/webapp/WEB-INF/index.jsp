<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Fruit Store</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<link rel="stylesheet" href="/css/main.css"/>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Fruit Store</h1>
	<main>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="theFruit" items="${fruit}">
			<tr>
				<td><c:out value="${theFruit.name}"></c:out></td>
				<td><c:out value="${theFruit.price}"></c:out></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</main>
</body>
</html>