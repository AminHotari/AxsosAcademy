<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Home</title>
</head>
<body>
	<header><h2>Home Page</h2></header>
	<main>
		<div>
			<a href="/products/new">New Product</a>
			<a href="/categories/new">New Category</a>
			<hr>
		</div>
		<div>
			<table>
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
				
				<tr>
					<td>
						<ul>
							<c:forEach var="product" items="${products}">
								<li><a href="/products/${product.id}"><c:out value="${product.name}"></c:out></a></li>
							</c:forEach>
						</ul>
					</td>
					<td>
						<ul>
							<c:forEach var="category" items="${categories}">
								<li><a href="/categories/${category.id}"><c:out value="${category.name}"></c:out></a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				
			</table>
		</div>
	</main>
</body>
</html>